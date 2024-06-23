USE [master]
GO
alter database [DiamondShop] set single_user with rollback immediate
DROP DATABASE [DiamondShop]
GO
CREATE DATABASE [DiamondShop]
GO
USE [DiamondShop]
GO
/****** Object:  Database [DiamondShop]    Script Date: 6/21/2024 4:41:29 PM ******/
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DiamondShop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DiamondShop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DiamondShop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DiamondShop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DiamondShop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DiamondShop] SET ARITHABORT OFF 
GO
ALTER DATABASE [DiamondShop] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [DiamondShop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DiamondShop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DiamondShop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DiamondShop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DiamondShop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DiamondShop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DiamondShop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DiamondShop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DiamondShop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [DiamondShop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DiamondShop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DiamondShop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DiamondShop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DiamondShop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DiamondShop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DiamondShop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DiamondShop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DiamondShop] SET  MULTI_USER 
GO
ALTER DATABASE [DiamondShop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DiamondShop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DiamondShop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DiamondShop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DiamondShop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DiamondShop] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DiamondShop] SET QUERY_STORE = ON
GO
ALTER DATABASE [DiamondShop] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [DiamondShop]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accounts](
	[AccountID] [varchar](6) NOT NULL,
	[UserName] [varchar](30) NULL,
	[FullName] [varchar](25) NULL,
	[Email] [varchar](50) NULL,
	[Password] [varchar](50) NULL,
	[PhoneNumber] [int] NULL,
	[Role] [varchar](2) NOT NULL,
	[Address] [varchar](125) NULL,
PRIMARY KEY CLUSTERED 
(
	[AccountID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[AccountID] [varchar](6) NOT NULL,
	[CartID] [varchar](3) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts_Products]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts_Products](
	[ProductID] [varchar](6) NOT NULL,
	[CartID] [varchar](3) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC,
	[CartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [varchar](3) NOT NULL,
	[CategoryName] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Deliveries]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deliveries](
	[DeliveryID] [varchar](6) NOT NULL,
	[OrderID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[Address] [varchar](125) NULL,
PRIMARY KEY CLUSTERED 
(
	[DeliveryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diamonds]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diamonds](
	[DiamondID] [varchar](3) NOT NULL,
	[CaratWeight] [real] NULL,
	[Color] [varchar](1) NULL,
	[Clarity] [varchar](4) NULL,
	[Cut] [varchar](12) NULL,
	[Price] [real] NULL,
	[Quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[DiamondID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Image](
	[ImageID] [varchar](10) NOT NULL,
	[ImageURL] [varchar](2000) NULL,
 CONSTRAINT [PK_Image_1] PRIMARY KEY CLUSTERED 
(
	[ImageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order Detail]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order Detail](
	[OrdersID] [varchar](6) NOT NULL,
	[ProductsID] [varchar](6) NOT NULL,
	[Quantity] [int] NULL,
	[Price] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrdersID] ASC,
	[ProductsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order Vouchers]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order Vouchers](
	[OrdersID] [varchar](6) NOT NULL,
	[PromotionsID] [varchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrdersID] ASC,
	[PromotionsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[TotalPrice] [real] NULL,
	[Address] [varchar](125) NULL,
	[StatusID] [int] NOT NULL,
 CONSTRAINT [PK__Orders__C3905BAF06F4EF69] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product_Image]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product_Image](
	[ImageID] [varchar](10) NOT NULL,
	[ImageURL] [varchar](2000) NULL,
 CONSTRAINT [PK_Image] PRIMARY KEY CLUSTERED 
(
	[ImageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [varchar](6) NOT NULL,
	[CategoryID] [varchar](3) NOT NULL,
	[ProductName] [varchar](30) NULL,
	[ProductSize] [int] NULL,
	[ProductPrice] [real] NULL,
	[DiamondID] [varchar](3) NOT NULL,
	[ShellID] [varchar](3) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[Quantity] [int] NULL,
	[ImageID] [varchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotion Detail]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotion Detail](
	[ProductsID] [varchar](6) NOT NULL,
	[PromotionsID] [varchar](6) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductsID] ASC,
	[PromotionsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotions]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotions](
	[PromotionID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[PromotionName] [int] NULL,
	[Type] [varchar](30) NULL,
	[Reduction] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[PromotionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Roles](
	[RoleID] [varchar](2) NOT NULL,
	[RoleName] [varchar](15) NULL,
PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Shells]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shells](
	[ShellID] [varchar](3) NOT NULL,
	[Material] [varchar](16) NULL,
	[Name] [varchar](20) NULL,
	[ShellPrice] [real] NULL,
	[Quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ShellID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Status]    Script Date: 6/21/2024 4:41:29 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Status](
	[StatusID] [int] NOT NULL,
	[StatusName] [nchar](25) NULL,
 CONSTRAINT [PK_Status] PRIMARY KEY CLUSTERED 
(
	[StatusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Accounts] ([AccountID], [UserName], [FullName], [Email], [Password], [PhoneNumber], [Role], [Address]) VALUES (N'AD001', N'Admin01', N'ADMIN', N'admin@gmail.com', N'admin001', 123456789, N'AD', N'')
INSERT [dbo].[Accounts] ([AccountID], [UserName], [FullName], [Email], [Password], [PhoneNumber], [Role], [Address]) VALUES (N'DS001', N'AnhHungDS', N'Nguyen Anh Hung', N'AnhHung@gmail.com', N'anhhungDS', 369852147, N'DS', N'Le Van Viet, TP Thu Duc, HCM')
INSERT [dbo].[Accounts] ([AccountID], [UserName], [FullName], [Email], [Password], [PhoneNumber], [Role], [Address]) VALUES (N'MN001', N'Manager01', N'MANAGER', N'manager01@gmail.com', N'manager001', 987654321, N'MN', N'')
INSERT [dbo].[Accounts] ([AccountID], [UserName], [FullName], [Email], [Password], [PhoneNumber], [Role], [Address]) VALUES (N'SS001', N'SuperSale', N'Nguyen Van A', N'SuperSale@gmail.com', N'nguyenasale', 24589751, N'SS', N'')
INSERT [dbo].[Accounts] ([AccountID], [UserName], [FullName], [Email], [Password], [PhoneNumber], [Role], [Address]) VALUES (N'US001', N'Lac Long', N'Long Hong Anh', N'laclongvang@gmail.com', N'laclong01', 98564127, N'US', N'97 Hoang Huu Nam, TP Thu Duc, HCM')
GO
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'001', N'Rings')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'002', N'Necklaces')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'003', N'Earrings')
INSERT [dbo].[Categories] ([CategoryID], [CategoryName]) VALUES (N'004', N'Bracelets')
GO
INSERT [dbo].[Diamonds] ([DiamondID], [CaratWeight], [Color], [Clarity], [Cut], [Price], [Quantity]) VALUES (N'1', 99, N'1', N'v1', N't1', 999.99, 50)
INSERT [dbo].[Diamonds] ([DiamondID], [CaratWeight], [Color], [Clarity], [Cut], [Price], [Quantity]) VALUES (N'2', 10, N'2', N'VD2', N'TD2', 123.45, 20)
INSERT [dbo].[Diamonds] ([DiamondID], [CaratWeight], [Color], [Clarity], [Cut], [Price], [Quantity]) VALUES (N'3', 55, N'3', N'vT03', N'Th03', 69.42, 10)
GO
INSERT [dbo].[Product_Image] ([ImageID], [ImageURL]) VALUES (N'1', NULL)
INSERT [dbo].[Product_Image] ([ImageID], [ImageURL]) VALUES (N'2', NULL)
INSERT [dbo].[Product_Image] ([ImageID], [ImageURL]) VALUES (N'3', NULL)
INSERT [dbo].[Product_Image] ([ImageID], [ImageURL]) VALUES (N'4', NULL)
INSERT [dbo].[Product_Image] ([ImageID], [ImageURL]) VALUES (N'5', NULL)
INSERT [dbo].[Product_Image] ([ImageID], [ImageURL]) VALUES (N'6', NULL)
GO
INSERT [dbo].[Products] ([ProductID], [CategoryID], [ProductName], [ProductSize], [ProductPrice], [DiamondID], [ShellID], [AccountID], [Quantity], [ImageID]) VALUES (N'PO0001', N'003', N'Dinamond Earring', 7, 98765.43, N'2', N'1', N'AD001', 15, N'1')
INSERT [dbo].[Products] ([ProductID], [CategoryID], [ProductName], [ProductSize], [ProductPrice], [DiamondID], [ShellID], [AccountID], [Quantity], [ImageID]) VALUES (N'PO0002', N'001', N'Dinamond Ring', 7, 12345.67, N'1', N'2', N'SS001', 7, N'2')
INSERT [dbo].[Products] ([ProductID], [CategoryID], [ProductName], [ProductSize], [ProductPrice], [DiamondID], [ShellID], [AccountID], [Quantity], [ImageID]) VALUES (N'PO0003', N'002', N'Dinamond Necklace', 12, 2468.1, N'3', N'3', N'MN001', 1, N'3')
INSERT [dbo].[Products] ([ProductID], [CategoryID], [ProductName], [ProductSize], [ProductPrice], [DiamondID], [ShellID], [AccountID], [Quantity], [ImageID]) VALUES (N'PO0004', N'001', N'Fake Fraud Faux Pas', 69, 420, N'1', N'1', N'DS001', 1, N'4')
INSERT [dbo].[Products] ([ProductID], [CategoryID], [ProductName], [ProductSize], [ProductPrice], [DiamondID], [ShellID], [AccountID], [Quantity], [ImageID]) VALUES (N'PO0006', N'001', N'Fake Fraud Faux Pas', 69, 420, N'1', N'1', N'SS001', 1, N'5')
GO
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'AD', N'Admin')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'DS', N'Delivery Staff')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'MN', N'Manager')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'SS', N'Sale Staff')
INSERT [dbo].[Roles] ([RoleID], [RoleName]) VALUES (N'US', N'User')
GO
INSERT [dbo].[Shells] ([ShellID], [Material], [Name], [ShellPrice], [Quantity]) VALUES (N'1', N'gold', N'midas gold', 999.99, 99)
INSERT [dbo].[Shells] ([ShellID], [Material], [Name], [ShellPrice], [Quantity]) VALUES (N'2', N'silver', N'green silver', 69.42, 77)
INSERT [dbo].[Shells] ([ShellID], [Material], [Name], [ShellPrice], [Quantity]) VALUES (N'3', N'nickel', N'shit nickel', 12.3, 55)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Accounts__87909B157D02296E]    Script Date: 6/21/2024 4:41:30 PM ******/
ALTER TABLE [dbo].[Accounts] ADD UNIQUE NONCLUSTERED 
(
	[Password] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Accounts__A9D1053417AE4FEC]    Script Date: 6/21/2024 4:41:30 PM ******/
ALTER TABLE [dbo].[Accounts] ADD UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD  CONSTRAINT [FKAccounts611768] FOREIGN KEY([Role])
REFERENCES [dbo].[Roles] ([RoleID])
GO
ALTER TABLE [dbo].[Accounts] CHECK CONSTRAINT [FKAccounts611768]
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FKCarts260125] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FKCarts260125]
GO
ALTER TABLE [dbo].[Carts_Products]  WITH CHECK ADD  CONSTRAINT [FKCarts_Prod173166] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Carts_Products] CHECK CONSTRAINT [FKCarts_Prod173166]
GO
ALTER TABLE [dbo].[Carts_Products]  WITH CHECK ADD  CONSTRAINT [FKCarts_Prod411921] FOREIGN KEY([CartID])
REFERENCES [dbo].[Carts] ([CartID])
GO
ALTER TABLE [dbo].[Carts_Products] CHECK CONSTRAINT [FKCarts_Prod411921]
GO
ALTER TABLE [dbo].[Deliveries]  WITH CHECK ADD  CONSTRAINT [FKDeliveries117408] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Deliveries] CHECK CONSTRAINT [FKDeliveries117408]
GO
ALTER TABLE [dbo].[Deliveries]  WITH CHECK ADD  CONSTRAINT [FKDeliveries195386] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Deliveries] CHECK CONSTRAINT [FKDeliveries195386]
GO
ALTER TABLE [dbo].[Order Detail]  WITH CHECK ADD  CONSTRAINT [FKOrder Deta734078] FOREIGN KEY([OrdersID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Order Detail] CHECK CONSTRAINT [FKOrder Deta734078]
GO
ALTER TABLE [dbo].[Order Detail]  WITH CHECK ADD  CONSTRAINT [FKOrder Deta796814] FOREIGN KEY([ProductsID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Order Detail] CHECK CONSTRAINT [FKOrder Deta796814]
GO
ALTER TABLE [dbo].[Order Vouchers]  WITH CHECK ADD  CONSTRAINT [FKOrder Vouc54425] FOREIGN KEY([OrdersID])
REFERENCES [dbo].[Orders] ([OrderID])
GO
ALTER TABLE [dbo].[Order Vouchers] CHECK CONSTRAINT [FKOrder Vouc54425]
GO
ALTER TABLE [dbo].[Order Vouchers]  WITH CHECK ADD  CONSTRAINT [FKOrder Vouc58278] FOREIGN KEY([PromotionsID])
REFERENCES [dbo].[Promotions] ([PromotionID])
GO
ALTER TABLE [dbo].[Order Vouchers] CHECK CONSTRAINT [FKOrder Vouc58278]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FK_Orders_Status] FOREIGN KEY([StatusID])
REFERENCES [dbo].[Status] ([StatusID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FK_Orders_Status]
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD  CONSTRAINT [FKOrders927413] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Orders] CHECK CONSTRAINT [FKOrders927413]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Product_Image] FOREIGN KEY([ImageID])
REFERENCES [dbo].[Product_Image] ([ImageID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Product_Image]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts714382] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts714382]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts742937] FOREIGN KEY([ShellID])
REFERENCES [dbo].[Shells] ([ShellID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts742937]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts921990] FOREIGN KEY([CategoryID])
REFERENCES [dbo].[Categories] ([CategoryID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts921990]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts972135] FOREIGN KEY([DiamondID])
REFERENCES [dbo].[Diamonds] ([DiamondID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts972135]
GO
ALTER TABLE [dbo].[Promotion Detail]  WITH CHECK ADD  CONSTRAINT [FKPromotion 38027] FOREIGN KEY([ProductsID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Promotion Detail] CHECK CONSTRAINT [FKPromotion 38027]
GO
ALTER TABLE [dbo].[Promotion Detail]  WITH CHECK ADD  CONSTRAINT [FKPromotion 834178] FOREIGN KEY([PromotionsID])
REFERENCES [dbo].[Promotions] ([PromotionID])
GO
ALTER TABLE [dbo].[Promotion Detail] CHECK CONSTRAINT [FKPromotion 834178]
GO
ALTER TABLE [dbo].[Promotions]  WITH CHECK ADD  CONSTRAINT [FKPromotions548842] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Promotions] CHECK CONSTRAINT [FKPromotions548842]
GO
USE [master]
GO
ALTER DATABASE [DiamondShop] SET  READ_WRITE 
GO

USE [DiamondShop]
GO

INSERT [dbo].Status([StatusID],[StatusName]) VALUES(0,N'On the way')
INSERT [dbo].Status([StatusID],[StatusName]) VALUES(1,N'Delivered')
INSERT [dbo].Status([StatusID],[StatusName]) VALUES(2,N'Cancelled')
