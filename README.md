# Bank Transfer Application

A simple Java banking application built with **Hibernate ORM** that supports balance checking and money transfers between accounts.

<img width="1528" height="908" alt="image" src="https://github.com/user-attachments/assets/d8817a08-6a4f-4665-9ec1-05d9fc6bdb8d" />
<img width="1519" height="902" alt="image" src="https://github.com/user-attachments/assets/d6230696-58cb-4eb8-bb05-f86b0dccb6bb" />



## Project Structure

```
src/
├── com/kce/in/
│   ├── bean/
│   │   ├── AccountBean.java       # Entity mapped to account_tbl
│   │   └── TransferBean.java      # Entity mapped to transfer_tbl
│   ├── dao/
│   │   └── BankDAO.java           # Database operations
│   ├── service/
│   │   └── BankService.java       # Business logic layer
│   └── main/
│       └── Main.java              # Entry point
└── com/kce/util/
    └── HibernateUtil.java         # Hibernate SessionFactory setup
```

## Features

- Check account balance
- Transfer money between accounts
- Account validation before transactions
- Automatic balance update after transfer

## Technologies Used

- Java
- Hibernate ORM (Jakarta Persistence)
- XML-based Hibernate configuration (`hibernate.cfg.xml`)

## Database Tables

| Table | Description |
|---|---|
| `account_tbl` | Stores account number, customer name, and balance |
| `transfer_tbl` | Stores transaction records including amount, date, and account numbers |

## Getting Started

1. Configure your database connection in `src/hibernate.cfg.xml`.
2. Ensure the `account_tbl` and `transfer_tbl` tables exist in your database.
3. Add at least two accounts (e.g., `1234567890` and `1234567891`) to `account_tbl`.
4. Run `Main.java` to execute a sample balance check and transfer.

## Sample Usage

```java
BankService bankService = new BankService();

// Check balance
System.out.println(bankService.checkBalance("1234567890"));

// Transfer money
TransferBean transferBean = new TransferBean();
transferBean.setFromAccountNumber("1234567890");
transferBean.setToAccountNumber("1234567891");
transferBean.setAmount(500);
transferBean.setDateOfTransaction(new java.util.Date());

System.out.println(bankService.transfer(transferBean));
```

## Notes

- `transactionId` in `TransferBean` must be set manually before transfer (auto-generation not configured).
- Balance is stored as `int` in `AccountBean`; amounts are handled as `float` internally.
