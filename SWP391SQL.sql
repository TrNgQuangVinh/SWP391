USE [master]
GO
ALTER DATABASE [DiamondShop] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
DROP DATABASE [DiamondShop]
GO	 
/****** Object:  Database [DiamondShop]    Script Date: 18-Jun-24 16:02:32 ******/
CREATE DATABASE [DiamondShop]
GO
USE DATABASE [DiamondShop]
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
/****** Object:  Table [dbo].[Accounts]    Script Date: 18-Jun-24 16:02:32 ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Password] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[AccountsAccountID] [varchar](6) NOT NULL,
	[CartID] [varchar](3) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts_Products]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts_Products](
	[ProductsProductID] [varchar](6) NOT NULL,
	[CartsCartID] [varchar](3) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductsProductID] ASC,
	[CartsCartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[category_id] [varchar](3) NOT NULL,
	[category_name] [varchar](100) NULL,
PRIMARY KEY CLUSTERED 
(
	[category_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Deliveries]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deliveries](
	[DeliveryID] [varchar](6) NOT NULL,
	[OrdersOrderID] [varchar](6) NOT NULL,
	[AccountsAccountID] [varchar](6) NOT NULL,
	[Address] [varchar](125) NULL,
PRIMARY KEY CLUSTERED 
(
	[DeliveryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diamonds]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diamonds](
	[diamond_id] [varchar](3) NOT NULL,
	[carat_weight] [real] NULL,
	[Color] [varchar](1) NULL,
	[Clarity] [varchar](4) NULL,
	[Cut] [varchar](12) NULL,
	[Price] [real] NULL,
	[Quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[diamond_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order Detail]    Script Date: 18-Jun-24 16:02:32 ******/
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
/****** Object:  Table [dbo].[Order Vouchers]    Script Date: 18-Jun-24 16:02:32 ******/
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
/****** Object:  Table [dbo].[Orders]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[TotalPrice] [real] NULL,
	[Address] [varchar](125) NULL,
	[StatusID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[product_id] [varchar](6) NOT NULL,
	[category_id] [varchar](3) NOT NULL,
	[product_name] [varchar](30) NULL,
	[product_size] [int] NULL,
	[product_price] [real] NULL,
	[diamond_id] [varchar](3) NOT NULL,
	[shell_id] [varchar](3) NOT NULL,
	[account_id] [varchar](6) NOT NULL,
	[quantity] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotion Detail]    Script Date: 18-Jun-24 16:02:32 ******/
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
/****** Object:  Table [dbo].[Promotions]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Promotions](
	[PromotionID] [varchar](6) NOT NULL,
	[AccountsAccountID] [varchar](6) NOT NULL,
	[PromotionName] [int] NULL,
	[Type] [varchar](30) NULL,
	[Reduction] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[PromotionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 18-Jun-24 16:02:32 ******/
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
/****** Object:  Table [dbo].[Shells]    Script Date: 18-Jun-24 16:02:32 ******/
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
/****** Object:  Table [dbo].[Status]    Script Date: 18-Jun-24 16:02:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Status](
	[StatusID] [int] NOT NULL,
	[StatusName] [varchar](25) NULL,
 CONSTRAINT [PK_Status] PRIMARY KEY CLUSTERED 
(
	[StatusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Accounts]  WITH CHECK ADD  CONSTRAINT [FKAccounts611768] FOREIGN KEY([Role])
REFERENCES [dbo].[Roles] ([RoleID])
GO
ALTER TABLE [dbo].[Accounts] CHECK CONSTRAINT [FKAccounts611768]
GO
ALTER TABLE [dbo].[Carts]  WITH CHECK ADD  CONSTRAINT [FKCarts260125] FOREIGN KEY([AccountsAccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Carts] CHECK CONSTRAINT [FKCarts260125]
GO
ALTER TABLE [dbo].[Carts_Products]  WITH CHECK ADD  CONSTRAINT [FKCarts_Prod173166] FOREIGN KEY([ProductsProductID])
REFERENCES [dbo].[Products] ([product_id])
GO
ALTER TABLE [dbo].[Carts_Products] CHECK CONSTRAINT [FKCarts_Prod173166]
GO
ALTER TABLE [dbo].[Carts_Products]  WITH CHECK ADD  CONSTRAINT [FKCarts_Prod411921] FOREIGN KEY([CartsCartID])
REFERENCES [dbo].[Carts] ([CartID])
GO
ALTER TABLE [dbo].[Carts_Products] CHECK CONSTRAINT [FKCarts_Prod411921]
GO
ALTER TABLE [dbo].[Deliveries]  WITH CHECK ADD  CONSTRAINT [FKDeliveries117408] FOREIGN KEY([AccountsAccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Deliveries] CHECK CONSTRAINT [FKDeliveries117408]
GO
ALTER TABLE [dbo].[Deliveries]  WITH CHECK ADD  CONSTRAINT [FKDeliveries195386] FOREIGN KEY([OrdersOrderID])
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
REFERENCES [dbo].[Products] ([product_id])
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
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts714382] FOREIGN KEY([account_id])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts714382]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts742937] FOREIGN KEY([shell_id])
REFERENCES [dbo].[Shells] ([ShellID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts742937]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts921990] FOREIGN KEY([category_id])
REFERENCES [dbo].[Categories] ([category_id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts921990]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FKProducts972135] FOREIGN KEY([diamond_id])
REFERENCES [dbo].[Diamonds] ([diamond_id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FKProducts972135]
GO
ALTER TABLE [dbo].[Promotion Detail]  WITH CHECK ADD  CONSTRAINT [FKPromotion 38027] FOREIGN KEY([ProductsID])
REFERENCES [dbo].[Products] ([product_id])
GO
ALTER TABLE [dbo].[Promotion Detail] CHECK CONSTRAINT [FKPromotion 38027]
GO
ALTER TABLE [dbo].[Promotion Detail]  WITH CHECK ADD  CONSTRAINT [FKPromotion 834178] FOREIGN KEY([PromotionsID])
REFERENCES [dbo].[Promotions] ([PromotionID])
GO
ALTER TABLE [dbo].[Promotion Detail] CHECK CONSTRAINT [FKPromotion 834178]
GO
ALTER TABLE [dbo].[Promotions]  WITH CHECK ADD  CONSTRAINT [FKPromotions548842] FOREIGN KEY([AccountsAccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Promotions] CHECK CONSTRAINT [FKPromotions548842]
GO
USE [master]
GO
ALTER DATABASE [DiamondShop] SET  READ_WRITE 
GO

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

INSERT [dbo].[Categories]([category_id],[category_name]) VALUES(N'001',N'Rings')
INSERT [dbo].[Categories]([category_id],[category_name]) VALUES(N'002',N'Necklaces')
INSERT [dbo].[Categories]([category_id],[category_name]) VALUES(N'003',N'Earrings')
INSERT [dbo].[Categories]([category_id],[category_name]) VALUES(N'004',N'Bracelets')

INSERT [dbo].[Diamonds]([diamond_id],[carat_weight],[Clarity],[Color],[Cut],[Price],[Quantity]) VALUES(N'1',N'2',N'VSS1',N'E',N'57',N'800000',N'12')
INSERT [dbo].[Diamonds]([diamond_id],[carat_weight],[Clarity],[Color],[Cut],[Price],[Quantity]) VALUES(N'2',N'4',N'VSS2',N'D',N'58',N'950000',N'10')

INSERT [dbo].[Shells]([ShellID],[Name],[Material],[ShellPrice],[Quantity]) VALUES(N'1',N'Pure Ring',N'Gold',N'100000',N'10')
INSERT [dbo].[Shells]([ShellID],[Name],[Material],[ShellPrice],[Quantity]) VALUES(N'2',N'Pure Ring',N'Silver',N'100000',10)

INSERT [dbo].[Status]([StatusID],[StatusName]) VALUES(0,N'On Delivery')
INSERT [dbo].[Status]([StatusID],[StatusName]) VALUES(1,N'Delivered')
INSERT [dbo].[Status]([StatusID],[StatusName]) VALUES(2,N'Cancelled')

