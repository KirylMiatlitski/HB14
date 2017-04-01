USE [JavaCourse]
GO

/****** Object:  Table [dbo].[TestUserTable]    Script Date: 19-Mar-17 17:04:11 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Products](
	[ID] [int]  IDENTITY(1,1)  PRIMARY KEY NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](50) NULL,
	[OwnerID] [int] NULL,
	[Status] [nvarchar](50) NULL,
 )
GO


