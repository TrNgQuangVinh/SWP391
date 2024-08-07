USE [DiamondShop]
GO
ALTER TABLE [dbo].[Warranty] DROP CONSTRAINT [FK_Warranty_Warranty]
GO
ALTER TABLE [dbo].[Warranty] DROP CONSTRAINT [FK_Warranty_Accounts]
GO
ALTER TABLE [dbo].[Promotions] DROP CONSTRAINT [FKPromotions548842]
GO
ALTER TABLE [dbo].[Promotion Detail] DROP CONSTRAINT [FKPromotion 834178]
GO
ALTER TABLE [dbo].[Promotion Detail] DROP CONSTRAINT [FKPromotion 38027]
GO
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FKProducts972135]
GO
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FKProducts921990]
GO
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FKProducts742937]
GO
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FKProducts714382]
GO
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FK_Products_Products]
GO
ALTER TABLE [dbo].[Products] DROP CONSTRAINT [FK_Products_Material]
GO
ALTER TABLE [dbo].[Orders] DROP CONSTRAINT [FKOrders927413]
GO
ALTER TABLE [dbo].[Orders] DROP CONSTRAINT [FK_Orders_Status]
GO
ALTER TABLE [dbo].[Order Vouchers] DROP CONSTRAINT [FKOrder Vouc58278]
GO
ALTER TABLE [dbo].[Order Vouchers] DROP CONSTRAINT [FKOrder Vouc54425]
GO
ALTER TABLE [dbo].[Order Detail] DROP CONSTRAINT [FKOrder Deta796814]
GO
ALTER TABLE [dbo].[Order Detail] DROP CONSTRAINT [FKOrder Deta734078]
GO
ALTER TABLE [dbo].[Feedback] DROP CONSTRAINT [FK_Feedback_Products]
GO
ALTER TABLE [dbo].[Deliveries] DROP CONSTRAINT [FKDeliveries195386]
GO
ALTER TABLE [dbo].[Deliveries] DROP CONSTRAINT [FKDeliveries117408]
GO
ALTER TABLE [dbo].[Certificate] DROP CONSTRAINT [FK_Certificate_Diamonds]
GO
ALTER TABLE [dbo].[Carts_Products] DROP CONSTRAINT [FKCarts_Prod411921]
GO
ALTER TABLE [dbo].[Carts_Products] DROP CONSTRAINT [FKCarts_Prod173166]
GO
ALTER TABLE [dbo].[Carts] DROP CONSTRAINT [FKCarts260125]
GO
ALTER TABLE [dbo].[Accounts] DROP CONSTRAINT [FKAccounts611768]
GO
/****** Object:  Index [IX_Feedback]    Script Date: 7/20/2024 11:25:10 AM ******/
DROP INDEX [IX_Feedback] ON [dbo].[Feedback]
GO
/****** Object:  Table [dbo].[Warranty]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Warranty]') AND type in (N'U'))
DROP TABLE [dbo].[Warranty]
GO
/****** Object:  Table [dbo].[Status]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Status]') AND type in (N'U'))
DROP TABLE [dbo].[Status]
GO
/****** Object:  Table [dbo].[Shells]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Shells]') AND type in (N'U'))
DROP TABLE [dbo].[Shells]
GO
/****** Object:  Table [dbo].[Roles]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Roles]') AND type in (N'U'))
DROP TABLE [dbo].[Roles]
GO
/****** Object:  Table [dbo].[Promotions]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Promotions]') AND type in (N'U'))
DROP TABLE [dbo].[Promotions]
GO
/****** Object:  Table [dbo].[Promotion Detail]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Promotion Detail]') AND type in (N'U'))
DROP TABLE [dbo].[Promotion Detail]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Products]') AND type in (N'U'))
DROP TABLE [dbo].[Products]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Orders]') AND type in (N'U'))
DROP TABLE [dbo].[Orders]
GO
/****** Object:  Table [dbo].[Order Vouchers]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Order Vouchers]') AND type in (N'U'))
DROP TABLE [dbo].[Order Vouchers]
GO
/****** Object:  Table [dbo].[Order Detail]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Order Detail]') AND type in (N'U'))
DROP TABLE [dbo].[Order Detail]
GO
/****** Object:  Table [dbo].[Material]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Material]') AND type in (N'U'))
DROP TABLE [dbo].[Material]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Image]') AND type in (N'U'))
DROP TABLE [dbo].[Image]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Feedback]') AND type in (N'U'))
DROP TABLE [dbo].[Feedback]
GO
/****** Object:  Table [dbo].[Diamonds]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Diamonds]') AND type in (N'U'))
DROP TABLE [dbo].[Diamonds]
GO
/****** Object:  Table [dbo].[Deliveries]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Deliveries]') AND type in (N'U'))
DROP TABLE [dbo].[Deliveries]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Certificate]') AND type in (N'U'))
DROP TABLE [dbo].[Certificate]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Categories]') AND type in (N'U'))
DROP TABLE [dbo].[Categories]
GO
/****** Object:  Table [dbo].[Carts_Products]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Carts_Products]') AND type in (N'U'))
DROP TABLE [dbo].[Carts_Products]
GO
/****** Object:  Table [dbo].[Carts]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Carts]') AND type in (N'U'))
DROP TABLE [dbo].[Carts]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 7/20/2024 11:25:10 AM ******/
IF  EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Accounts]') AND type in (N'U'))
DROP TABLE [dbo].[Accounts]
GO
USE [master]
GO
/****** Object:  Database [DiamondShop]    Script Date: 7/20/2024 11:25:10 AM ******/
alter database [DiamondShop] set single_user with rollback immediate
drop database [DiamondShop]
go
/****** Object:  Database [DiamondShop]    Script Date: 7/20/2024 11:25:10 AM ******/
CREATE DATABASE [DiamondShop]
 CONTAINMENT = NONE

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
ALTER DATABASE [DiamondShop] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200)
GO
USE [DiamondShop]
GO
/****** Object:  Table [dbo].[Accounts]    Script Date: 7/20/2024 11:25:10 AM ******/
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
	[PhoneNumber] [varchar](14) NULL,
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
/****** Object:  Table [dbo].[Carts]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts](
	[CartID] [varchar](3) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[TotalPrice] [real] NULL,
PRIMARY KEY CLUSTERED 
(
	[CartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Carts_Products]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Carts_Products](
	[CartID] [varchar](3) NOT NULL,
	[ProductID] [varchar](6) NOT NULL,
	[ProductName] [varchar](2000) NULL,
	[Quantity] [int] NOT NULL,
	[Price] [real] NULL,
	[ProductSize] [real] NULL,
 CONSTRAINT [PK__Carts_Pr__D1170B9469EE965C] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC,
	[CartID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoryID] [int] NOT NULL,
	[CategoryName] [varchar](100) NULL,
 CONSTRAINT [PK__Categori__19093A2B0DED573E] PRIMARY KEY CLUSTERED 
(
	[CategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Certificate]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Certificate](
	[CertificateID] [varchar](12) NOT NULL,
	[Date] [date] NULL,
	[DiamondID] [int] NULL,
	[Measurement] [varchar](255) NULL,
 CONSTRAINT [PK_Certificate] PRIMARY KEY CLUSTERED 
(
	[CertificateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Deliveries]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Deliveries](
	[DeliveryID] [varchar](6) NOT NULL,
	[OrderID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[Address] [varchar](125) NULL,
	[StatusID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[DeliveryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Diamonds]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Diamonds](
	[DiamondID] [int] NOT NULL,
	[CaratWeight] [real] NULL,
	[Color] [varchar](1) NULL,
	[Clarity] [varchar](4) NULL,
	[Cut] [varchar](12) NULL,
	[Price] [real] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK__Diamonds__23A8E7BBFC4AE465] PRIMARY KEY CLUSTERED 
(
	[DiamondID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Feedback]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Feedback](
	[FeedbackID] [varchar](8) NOT NULL,
	[FeedbackContent] [nvarchar](4000) NULL,
	[Rating] [real] NOT NULL,
	[ProductID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[Date] [date] NULL,
 CONSTRAINT [PK_Feedback] PRIMARY KEY CLUSTERED 
(
	[FeedbackID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Image]    Script Date: 7/20/2024 11:25:10 AM ******/
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
/****** Object:  Table [dbo].[Material]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Material](
	[MaterialID] [int] NOT NULL,
	[MaterialName] [varchar](50) NULL,
 CONSTRAINT [PK_Material] PRIMARY KEY CLUSTERED 
(
	[MaterialID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order Detail]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order Detail](
	[OrdersID] [varchar](6) NOT NULL,
	[ProductsID] [varchar](6) NOT NULL,
	[Quantity] [int] NULL,
	[ProductsSize] [real] NULL,
	[Price] [real] NULL,
 CONSTRAINT [PK__Order De__28BF178ACCB9F1D0] PRIMARY KEY CLUSTERED 
(
	[OrdersID] ASC,
	[ProductsID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Order Vouchers]    Script Date: 7/20/2024 11:25:10 AM ******/
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
/****** Object:  Table [dbo].[Orders]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[OrderID] [varchar](6) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[TotalPrice] [real] NULL,
	[Address] [varchar](125) NULL,
	[Date] [datetime] NULL,
	[StatusID] [int] NOT NULL,
 CONSTRAINT [PK__Orders__C3905BAF06F4EF69] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[ProductID] [varchar](6) NOT NULL,
	[CategoryID] [int] NOT NULL,
	[ProductName] [varchar](2000) NULL,
	[ProductSize] [real] NULL,
	[ProductPrice] [real] NULL,
	[DiamondID] [int] NOT NULL,
	[ShellID] [int] NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[MaterialID] [int] NOT NULL,
	[Quantity] [int] NULL,
	[Description] [varchar](8000) NULL,
	[ImageLink] [varchar](2000) NULL,
 CONSTRAINT [PK__Products__B40CC6ED1A53337F] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Promotion Detail]    Script Date: 7/20/2024 11:25:10 AM ******/
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
/****** Object:  Table [dbo].[Promotions]    Script Date: 7/20/2024 11:25:10 AM ******/
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
/****** Object:  Table [dbo].[Roles]    Script Date: 7/20/2024 11:25:10 AM ******/
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
/****** Object:  Table [dbo].[Shells]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Shells](
	[ShellID] [int] NOT NULL,
	[Name] [varchar](20) NULL,
	[ShellPrice] [real] NULL,
	[Quantity] [int] NULL,
 CONSTRAINT [PK__Shells__DB5C54BDB1A9ADA0] PRIMARY KEY CLUSTERED 
(
	[ShellID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Status]    Script Date: 7/20/2024 11:25:10 AM ******/
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
/****** Object:  Table [dbo].[Warranty]    Script Date: 7/20/2024 11:25:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Warranty](
	[WarrantyID] [varchar](7) NOT NULL,
	[AccountID] [varchar](6) NOT NULL,
	[ProductID] [varchar](6) NOT NULL,
	[PurchaseDate] [date] NOT NULL,
	[WarrantyUntil] [date] NOT NULL,
 CONSTRAINT [PK_Warranty] PRIMARY KEY CLUSTERED 
(
	[WarrantyID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [IX_Feedback]    Script Date: 7/20/2024 11:25:10 AM ******/
CREATE NONCLUSTERED INDEX [IX_Feedback] ON [dbo].[Feedback]
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
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
ALTER TABLE [dbo].[Certificate]  WITH CHECK ADD  CONSTRAINT [FK_Certificate_Diamonds] FOREIGN KEY([DiamondID])
REFERENCES [dbo].[Diamonds] ([DiamondID])
GO
ALTER TABLE [dbo].[Certificate] CHECK CONSTRAINT [FK_Certificate_Diamonds]
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
ALTER TABLE [dbo].[Feedback]  WITH CHECK ADD  CONSTRAINT [FK_Feedback_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Feedback] CHECK CONSTRAINT [FK_Feedback_Products]
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
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Material] FOREIGN KEY([MaterialID])
REFERENCES [dbo].[Material] ([MaterialID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Material]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Products] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Products]
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
ALTER TABLE [dbo].[Warranty]  WITH CHECK ADD  CONSTRAINT [FK_Warranty_Accounts] FOREIGN KEY([AccountID])
REFERENCES [dbo].[Accounts] ([AccountID])
GO
ALTER TABLE [dbo].[Warranty] CHECK CONSTRAINT [FK_Warranty_Accounts]
GO
ALTER TABLE [dbo].[Warranty]  WITH CHECK ADD  CONSTRAINT [FK_Warranty_Warranty] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Products] ([ProductID])
GO
ALTER TABLE [dbo].[Warranty] CHECK CONSTRAINT [FK_Warranty_Warranty]
GO
USE [master]
GO
ALTER DATABASE [DiamondShop] SET  READ_WRITE 
GO
