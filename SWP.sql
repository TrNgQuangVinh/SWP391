use [master]
GO
DROP DATABASE [DiamondShop]
GO
CREATE DATABASE [DiamondShop]
USE [DiamondShop]
GO
CREATE TABLE Products (
  ProductID         varchar(6) NOT NULL, 
  CategoryID        varchar(3) NOT NULL, 
  ProductName       varchar(30) NULL, 
  ProductSize       int NULL, 
  ProductPrice      float(10) NULL, 
  DiamondsDiamondID varchar(3) NOT NULL, 
  ShellsShellID     varchar(3) NOT NULL, 
  AccountsAccountID varchar(6) NOT NULL, 
  PRIMARY KEY (ProductID));
CREATE TABLE Orders (
  OrderID           varchar(6) NOT NULL, 
  AccountsAccountID varchar(6) NOT NULL, 
  TotalPrice        float(10) NULL, 
  Address           varchar(125) NULL, 
  PRIMARY KEY (OrderID));
CREATE TABLE Deliveries (
  DeliveryID        varchar(6) NOT NULL, 
  OrdersOrderID     varchar(6) NOT NULL, 
  AccountsAccountID varchar(6) NOT NULL, 
  Address           varchar(125) NULL, 
  PRIMARY KEY (DeliveryID));
CREATE TABLE Promotions (
  PromotionID       varchar(6) NOT NULL, 
  AccountsAccountID varchar(6) NOT NULL, 
  PromotionName     int NULL, 
  Type              varchar(30) NULL, 
  Reduction         float(3) NULL, 
  PRIMARY KEY (PromotionID));
CREATE TABLE [Order Detail] (
  OrdersID   varchar(6) NOT NULL, 
  ProductsID varchar(6) NOT NULL, 
  Quantity   int NULL, 
  Price      float(10) NULL, 
  PRIMARY KEY (OrdersID, 
  ProductsID));
CREATE TABLE [Order Vouchers] (
  OrdersID     varchar(6) NOT NULL, 
  PromotionsID varchar(6) NOT NULL, 
  PRIMARY KEY (OrdersID, 
  PromotionsID));
CREATE TABLE [Promotion Detail] (
  ProductsID   varchar(6) NOT NULL, 
  PromotionsID varchar(6) NOT NULL, 
  PRIMARY KEY (ProductsID, 
  PromotionsID));
CREATE TABLE Diamonds (
  DiamondID   varchar(3) NOT NULL, 
  CaratWeight float(4) NULL, 
  Color       varchar(1) NULL, 
  Clarity     varchar(4) NULL, 
  Cut         varchar(12) NULL, 
  Price       float(10) NULL, 
  PRIMARY KEY (DiamondID));
CREATE TABLE Shells (
  ShellID    varchar(3) NOT NULL, 
  Material   varchar(16) NULL, 
  Name       varchar(20) NULL, 
  ShellPrice float(10) NULL, 
  PRIMARY KEY (ShellID));
CREATE TABLE Accounts (
  AccountID   varchar(6) NOT NULL, 
  UserName    varchar(30) NULL, 
  FullName    varchar(25) NULL, 
  Email       varchar(50) NULL UNIQUE, 
  Password    varchar(50) NULL UNIQUE, 
  PhoneNumber int NULL, 
  Role        varchar(2) NOT NULL, 
  Address     varchar(125) NULL, 
  PRIMARY KEY (AccountID));
CREATE TABLE Categories (
  CategoryID   varchar(3) NOT NULL, 
  CategoryName varchar(100) NULL, 
  PRIMARY KEY (CategoryID));
CREATE TABLE Roles (
  RoleID   varchar(2) NOT NULL, 
  RoleName varchar(15) NULL, 
  PRIMARY KEY (RoleID));
CREATE TABLE Carts (
  AccountsAccountID varchar(6) NOT NULL, 
  CartID            varchar(3) NOT NULL, 
  PRIMARY KEY (CartID));
CREATE TABLE Carts_Products (
  ProductsProductID varchar(6) NOT NULL, 
  CartsCartID       varchar(3) NOT NULL, 
  PRIMARY KEY (ProductsProductID, 
  CartsCartID));
ALTER TABLE [Order Detail] ADD CONSTRAINT [FKOrder Deta734078] FOREIGN KEY (OrdersID) REFERENCES Orders (OrderID);
ALTER TABLE [Order Detail] ADD CONSTRAINT [FKOrder Deta796814] FOREIGN KEY (ProductsID) REFERENCES Products (ProductID);
ALTER TABLE [Order Vouchers] ADD CONSTRAINT [FKOrder Vouc54425] FOREIGN KEY (OrdersID) REFERENCES Orders (OrderID);
ALTER TABLE [Order Vouchers] ADD CONSTRAINT [FKOrder Vouc58278] FOREIGN KEY (PromotionsID) REFERENCES Promotions (PromotionID);
ALTER TABLE [Promotion Detail] ADD CONSTRAINT [FKPromotion 38027] FOREIGN KEY (ProductsID) REFERENCES Products (ProductID);
ALTER TABLE [Promotion Detail] ADD CONSTRAINT [FKPromotion 834178] FOREIGN KEY (PromotionsID) REFERENCES Promotions (PromotionID);
ALTER TABLE Deliveries ADD CONSTRAINT FKDeliveries195386 FOREIGN KEY (OrdersOrderID) REFERENCES Orders (OrderID);
ALTER TABLE Orders ADD CONSTRAINT FKOrders927413 FOREIGN KEY (AccountsAccountID) REFERENCES Accounts (AccountID);
ALTER TABLE Products ADD CONSTRAINT FKProducts972135 FOREIGN KEY (DiamondsDiamondID) REFERENCES Diamonds (DiamondID);
ALTER TABLE Products ADD CONSTRAINT FKProducts742937 FOREIGN KEY (ShellsShellID) REFERENCES Shells (ShellID);
ALTER TABLE Products ADD CONSTRAINT FKProducts921990 FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID);
ALTER TABLE Deliveries ADD CONSTRAINT FKDeliveries117408 FOREIGN KEY (AccountsAccountID) REFERENCES Accounts (AccountID);
ALTER TABLE Accounts ADD CONSTRAINT FKAccounts611768 FOREIGN KEY (Role) REFERENCES Roles (RoleID);
ALTER TABLE Promotions ADD CONSTRAINT FKPromotions548842 FOREIGN KEY (AccountsAccountID) REFERENCES Accounts (AccountID);
ALTER TABLE Products ADD CONSTRAINT FKProducts714382 FOREIGN KEY (AccountsAccountID) REFERENCES Accounts (AccountID);
ALTER TABLE Carts ADD CONSTRAINT FKCarts260125 FOREIGN KEY (AccountsAccountID) REFERENCES Accounts (AccountID);
ALTER TABLE Carts_Products ADD CONSTRAINT FKCarts_Prod411921 FOREIGN KEY (CartsCartID) REFERENCES Carts (CartID);
ALTER TABLE Carts_Products ADD CONSTRAINT FKCarts_Prod173166 FOREIGN KEY (ProductsProductID) REFERENCES Products (ProductID);

INSERT [dbo].[Roles]([RoleID],[RoleName]) VALUES (N'AD',N'Admin')
INSERT [dbo].[Roles]([RoleID],[RoleName]) VALUES (N'US',N'User')
INSERT [dbo].[Roles]([RoleID],[RoleName]) VALUES (N'MN',N'Manager')
INSERT [dbo].[Roles]([RoleID],[RoleName]) VALUES (N'DS',N'Delivery Staff')
INSERT [dbo].[Roles]([RoleID],[RoleName]) VALUES (N'SS',N'Sale Staff')

INSERT [dbo].[Accounts]([AccountID],[Email],[Password],[FullName],[UserName],[PhoneNumber],[Address],[Role]) 
VALUES (N'AD001',N'admin@gmail.com',N'admin001',N'ADMIN',N'Admin01',N'0123456789',N'',N'AD')
INSERT [dbo].[Accounts]([AccountID],[Email],[Password],[FullName],[UserName],[PhoneNumber],[Address],[Role]) 
VALUES (N'MN001',N'manager01@gmail.com',N'manager001',N'MANAGER',N'Manager01',N'0987654321',N'',N'MN')
INSERT [dbo].[Accounts]([AccountID],[Email],[Password],[FullName],[UserName],[PhoneNumber],[Address],[Role]) 
VALUES (N'DS001',N'AnhHung@gmail.com',N'anhhungDS',N'Nguyen Anh Hung',N'AnhHungDS',N'369852147',N'Le Van Viet, TP Thu Duc, HCM',N'DS')
INSERT [dbo].[Accounts]([AccountID],[Email],[Password],[FullName],[UserName],[PhoneNumber],[Address],[Role]) 
VALUES (N'SS001',N'SuperSale@gmail.com',N'nguyenasale',N'Nguyen Van A',N'SuperSale',N'024589751',N'',N'SS')
INSERT [dbo].[Accounts]([AccountID],[Email],[Password],[FullName],[UserName],[PhoneNumber],[Address],[Role]) 
VALUES (N'US001',N'laclongvang@gmail.com',N'laclong01',N'Long Hong Anh',N'Lac Long',N'098564127',N'97 Hoang Huu Nam, TP Thu Duc, HCM',N'US')

