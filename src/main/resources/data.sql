DROP TABLE IF EXISTS nalaccount;

CREATE TABLE nalaccount (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  parent_id INT
);

INSERT INTO nalaccount (id, name, parent_id) VALUES
(1, 'Asset', NULL),
(2, 'Current Asset', 1),
(3, 'Inventory', 2),
(4, 'Sundry Deptors(Accounts Receivable)', 2),
(5, 'Bank Accounts', 2),
(6, 'Investments', 2),
(7, 'Loans and advances', 2),
(8, 'Cash In Hand', 2),
(9, 'Imprest Money', 2),
(10, 'Fixed Assets', 1),
(11, 'Landline and Building', 10),
(12, 'Furniture and Fixtures', 10),
(13, 'Plant and Machinery', 10),
(14, 'Income Account', NULL),
(15, 'Sales Account', 14),
(16, 'Direct Income', 14),
(17, 'Indirect Income', 14),
(18, 'Expense Accounts', NULL),
(19, 'Purchase Accounts', 18),
(20, 'Direct Expense', 18),
(21, 'Indirect Expense', 18);
