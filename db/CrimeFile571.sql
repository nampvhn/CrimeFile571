USE [master];
GO

IF (EXISTS (SELECT * FROM sys.sysdatabases WHERE name = N'CrimeFile571'))
	DROP DATABASE [CrimeFile571];
GO

CREATE DATABASE [CrimeFile571];
GO

USE [CrimeFile571];
GO

CREATE TABLE [Roles] (
	[RoleID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[RoleName] nvarchar(50) NOT NULL,
	[Description] ntext NULL,
	[Status] tinyint DEFAULT 1 NOT NULL
		-- 0: Inactive
		-- 1: Active
);
GO

CREATE TABLE [Users] (
	[UserID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[RoleID] int NOT NULL REFERENCES [Roles],
	[Username] varchar(100) NOT NULL UNIQUE,
	[Password] varchar(100) NOT NULL,
	[FullName] nvarchar(100) NOT NULL,
	[Rank] nvarchar(100) NULL,
	[Gender] tinyint NULL,
	[Birthday] datetime CHECK ([Birthday] <= getDate()) NULL,
	[Phone] varchar(20) NULL,
	[Email] varchar(100) NULL,
	[Address] ntext NULL,
	[Image] nvarchar(100) NULL,
	[LastLogin] datetime NULL,
	[Status] tinyint DEFAULT 1 NOT NULL
		-- 0: Inactive
		-- 1: Active
);
GO

CREATE TABLE [ComplaintTypes] (
	[CplTypeID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CplTypeName] nvarchar(100) NOT NULL UNIQUE,
	[Description] ntext NULL
);
GO

CREATE TABLE [Complainants] (
	[CplnID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[FullName] nvarchar(100) NOT NULL,
	[IdentityCard] varchar(20) NULL,
	[PassportNo] varchar(20) NULL,
	[Nationality] nvarchar(100) NOT NULL,
	[Gender] tinyint NOT NULL,
	[Birthday] datetime CHECK ([Birthday] <= getDate()) NOT NULL,
	[Occupation] nvarchar(100) NULL,
	[Phone] varchar(20) NOT NULL,
	[Email] varchar(100) NULL,
	[Address] ntext NOT NULL,
	[RelativeName] nvarchar(200) NULL
);
GO

CREATE TABLE [Complaints] (
	[CompID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CplTypeID] int NOT NULL REFERENCES [ComplaintTypes],
	[Description] ntext NOT NULL,
	[CreatedDate] datetime DEFAULT getDate() NOT NULL,
	[ComplnID] int NOT NULL REFERENCES [Complainants],
	[UserID] int NOT NULL REFERENCES [Users],
	[Status] tinyint DEFAULT 0 NOT NULL,
		-- 0: Pending
		-- 1: Investigating
		-- 2: Finished
		-- 3: Reject
);
GO

CREATE TABLE [FIRs] (
	[FirID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[DateOfIncident] datetime CHECK ([DateOfIncident] <= getDate()) NOT NULL,
	[PlaceOfIncident] ntext NOT NULL,
	[Description] ntext NOT NULL,
	[ReasonDelay] ntext NULL,
	[CreatedDate] datetime DEFAULT getDate() NOT NULL,
	[ComplnID] int NOT NULL REFERENCES [Complainants],
	[UserID] int NOT NULL REFERENCES [Users],
	[Status] tinyint DEFAULT 1 NOT NULL,
		-- 0: Cancel
		-- 1: Investigating
		-- 2: Prepare Challan (Charge Sheet / Final Report)
		-- 3: Untrace
);
GO

CREATE TABLE [CaseRecords] (
	[CrID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CrName] nvarchar(200) NOT NULL,
	[DateOfIncident] datetime CHECK ([DateOfIncident] <= getDate()) NOT NULL,
	[PlaceOfIncident] ntext NOT NULL,
	[Motive] ntext NOT NULL,
	[Evidence] ntext NOT NULL,
	[Description] ntext NOT NULL,
	[LastUpdated] datetime DEFAULT getDate() NOT NULL,
	[UserID] int NOT NULL REFERENCES [Users]
);
GO

ALTER TABLE [CaseRecords] ALTER COLUMN [Description] ntext NULL;
GO

CREATE TABLE [CrimeTypes] (
	[CrimeTypeID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CrimeTypeName] nvarchar(100) NOT NULL,
	[Description] ntext NULL
);
GO

CREATE TABLE [Areas] (
	[AreaID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[AreaName] nvarchar(100)
);
GO

CREATE TABLE [Criminals] (
	[CriminalID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[FullName] nvarchar(100) NOT NULL,
	[NickName] nvarchar(100) NULL,
	[IdentityCard] varchar(15) NULL,
	[PassportNo] varchar(15) NULL,
	[Nationality] nvarchar(100) NOT NULL,
	[Gender] tinyint NOT NULL,
	[Birthday] datetime CHECK ([Birthday] <= getDate()) NOT NULL,
	[IdentificationMark] ntext NOT NULL,
	[Description] ntext NULL,
	[Mental] nvarchar(100) NULL,
	[Occupation] nvarchar(100) NULL,
	[ResidentialAddress] ntext NOT NULL,
	[PermanentAddress] ntext NOT NULL,
	[AreaID] int NOT NULL REFERENCES [Areas],
	[Fingerprint] varchar(100) NULL,
	[Image1] varchar(100) NULL,
	[Image2] varchar(100) NULL,
	[Image3] varchar(100) NULL,
	[IsPrisonner] bit NULL,
	[IsMostWanted] bit NULL,
	[RelativeName] nvarchar(200) NULL
);
GO

CREATE TABLE [CaseCriminal] (
	[CcID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CrID] int NOT NULL REFERENCES [CaseRecords],
	[CriminalID] int NOT NULL REFERENCES [Criminals]
);
GO

CREATE TABLE [CrimeCriminal] (
	[CrimeID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CrimeTypeID] int NOT NULL REFERENCES [CrimeTypes],
	[CriminalID] int NOT NULL REFERENCES [Criminals]
);
GO

CREATE TABLE [Victims] (
	[VictimID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CrID] int NOT NULL REFERENCES [CaseRecords],
	[FullName] nvarchar(100) NOT NULL,
	[Gender] tinyint NOT NULL,
	[Birthday] datetime CHECK ([Birthday] <= getDate()) NOT NULL,
	[Address] ntext NOT NULL,
	[Description] ntext NULL,
	[IsDead] bit NOT NULL,
	[RelativeName] nvarchar(200) NULL
);
GO

CREATE TABLE [Postmortems] (
	[PostmortemID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[VictimID] int NOT NULL REFERENCES [Victims],
	[DateOfDeath] datetime NOT NULL,
	[Reason] ntext NOT NULL,
	[Description] ntext NULL,
	[DateOfReport] datetime NOT NULL,
	[DoctorName] nvarchar(100) NOT NULL,
	[HospitalName] nvarchar(100) NOT NULL,
);
GO

CREATE TABLE [Prisons] (
	[PrisonID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[PrisonName] nvarchar(100) NOT NULL,
	[Address] ntext NOT NULL
);
GO

CREATE TABLE [Prisoners] (
	[PrisonerID] int IDENTITY(1, 1) NOT NULL PRIMARY KEY,
	[CriminalID] int NOT NULL REFERENCES [Criminals],
	[PrisonID] int NOT NULL REFERENCES [Prisons],
	[TimeInPrison] varchar(100) NOT NULL,
	[StartTime] datetime NOT NULL,
	[EndTime] datetime NOT NULL,
	CHECK ([StartTime] <= [EndTime])
);
GO

ALTER TABLE [Prisoners] ALTER COLUMN [EndTime] datetime NULL;
GO

-- INSERT DATA --

INSERT [Roles](RoleName) VALUES
	(N'Administrator'),
	(N'User');
GO

INSERT [Users]([RoleID], [Username], [Password], [FullName]) VALUES
	(1, 'admin', 'admin', N'Admin'),
	(2, 'user', 'user', N'User');
GO

INSERT [Areas]([AreaName]) VALUES
	(N'District A'),
	(N'District B'),
	(N'District C');
GO