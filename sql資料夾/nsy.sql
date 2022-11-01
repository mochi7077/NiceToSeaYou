-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- 主機： localhost:3306
-- 產生時間： 2022-09-21 14:29:03
-- 伺服器版本： 5.7.24
-- PHP 版本： 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫: `nsy`
--

-- --------------------------------------------------------

--
-- 資料表結構 `accounts`
--

CREATE TABLE `accounts` (
  `AccountId` int(11) NOT NULL,
  `Account` char(30) NOT NULL,
  `PassW` char(30) NOT NULL,
  `Mobile` char(30) NOT NULL,
  `CompanyName` char(60) NOT NULL,
  `TaxId` int(11) DEFAULT NULL,
  `Address` char(255) DEFAULT NULL,
  `EmailVerifyCode` char(30) NOT NULL,
  `Email` char(60) NOT NULL,
  `ContactPerson` char(60) DEFAULT NULL,
  `ContactPersonNum` char(30) DEFAULT NULL,
  `Fax` char(30) DEFAULT NULL,
  `BankAccount` int(11) DEFAULT NULL,
  `BankName` char(60) DEFAULT NULL,
  `BankSwiftCode` int(11) DEFAULT NULL,
  `LineAccount` char(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `accounts`
--

INSERT INTO `accounts` (`AccountId`, `Account`, `PassW`, `Mobile`, `CompanyName`, `TaxId`, `Address`, `EmailVerifyCode`, `Email`, `ContactPerson`, `ContactPersonNum`, `Fax`, `BankAccount`, `BankName`, `BankSwiftCode`, `LineAccount`) VALUES
(1, 'duck123', 'duck1234', '091234567', 'Duck的店', 99115599, 'xx.xxxx.xxxx', '4567', 'duck@gmail.com', '阿封', '091234567', '(04)-2326-5860', 12345678, '台新銀行', 812, 'duck100'),
(2, 'ericWang', 'eric1234', '9123459', '千萬屋', 88314578, 'yy.yyy.yyyy', '9874', 'eric@gmail.com', '王先生', '-22121208', '-8217', 123456755, '台新銀行', 812, 'eric100'),
(3, 'doudou', 'douGer123a', '9090909', '隨贏', 99114562, 'zz.zzz.zzzz', '1235', 'doudou@gmail.com', '豆先生', '-22121551', '-7517', 1234567891, '台新銀行', 812, 'dou100');

-- --------------------------------------------------------

--
-- 資料表結構 `autoorderconfirmfunctionstatus`
--

CREATE TABLE `autoorderconfirmfunctionstatus` (
  `StatusId` int(11) NOT NULL,
  `Status` char(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `autoorderconfirmfunctionstatus`
--

INSERT INTO `autoorderconfirmfunctionstatus` (`StatusId`, `Status`) VALUES
(1, '關閉'),
(2, '訂購數量小於【可出現貨】時自動接單'),
(3, '\"訂購數量小於【可出現貨】加上\r\n【已叫貨量】時自動接單\"'),
(4, '訂購數量小於【現貨保留數】時自動接單');

-- --------------------------------------------------------

--
-- 資料表結構 `companyfollowinglist`
--

CREATE TABLE `companyfollowinglist` (
  `BuyerId` int(11) NOT NULL,
  `SellerId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `companyfollowinglist`
--

INSERT INTO `companyfollowinglist` (`BuyerId`, `SellerId`) VALUES
(2, 1),
(3, 1),
(1, 2),
(1, 3);

-- --------------------------------------------------------

--
-- 資料表結構 `orderrecord`
--

CREATE TABLE `orderrecord` (
  `OrderId` int(11) NOT NULL,
  `OrderNum` char(60) NOT NULL,
  `BuyerId` int(11) NOT NULL,
  `SellerProductId` int(11) NOT NULL,
  `SellerId` int(11) NOT NULL,
  `OrderQty` int(11) NOT NULL,
  `OrderStatus` int(11) NOT NULL,
  `OrderTime` datetime DEFAULT NULL,
  `DealPrice` int(11) DEFAULT NULL,
  `PaymentTerms` char(30) NOT NULL DEFAULT '月結',
  `DeliveryOrderNum` char(60) DEFAULT NULL,
  `EstimatedArrilvalTime` datetime DEFAULT NULL,
  `DeliveryOrderRemark` char(60) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `orderrecord`
--

INSERT INTO `orderrecord` (`OrderId`, `OrderNum`, `BuyerId`, `SellerProductId`, `SellerId`, `OrderQty`, `OrderStatus`, `OrderTime`, `DealPrice`, `PaymentTerms`, `DeliveryOrderNum`, `EstimatedArrilvalTime`, `DeliveryOrderRemark`) VALUES
(1, '2D202209090001', 2, 100001, 1, 100, 1, '2020-08-01 12:00:00', NULL, '月結', 'EX1D202209090001', '2020-08-02 12:00:00', '一大早就要送');

-- --------------------------------------------------------

--
-- 資料表結構 `orderstatus`
--

CREATE TABLE `orderstatus` (
  `StatusId` int(11) NOT NULL,
  `Status` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `orderstatus`
--

INSERT INTO `orderstatus` (`StatusId`, `Status`) VALUES
(1, '貨單暫存_還沒送出訂單'),
(2, '待確認_訂單送出'),
(3, '配單中_訂單成立'),
(4, '已結單_建立撿貨/出貨單'),
(5, '待出貨_完成確認但還沒出貨'),
(6, '出貨中'),
(7, '待收貨_待收貨入庫'),
(8, '訂單完成_入庫完成'),
(9, '訂單不成立_賣家或買家取消');

-- --------------------------------------------------------

--
-- 資料表結構 `product`
--

CREATE TABLE `product` (
  `ProductId` int(11) NOT NULL,
  `OwnerId` int(11) NOT NULL,
  `ProductNameSpec` char(30) NOT NULL,
  `ProductPic` blob,
  `SupplierId` int(11) NOT NULL,
  `ProductClassification` int(11) NOT NULL,
  `UnitCost` int(11) NOT NULL DEFAULT '0',
  `StockQty` int(11) NOT NULL DEFAULT '0',
  `WarningQty` int(11) NOT NULL DEFAULT '0',
  `AutoOrderFunction` int(11) NOT NULL DEFAULT '0',
  `AutoOrderToQty` int(11) DEFAULT NULL,
  `OrderWaitingHour` int(11) DEFAULT NULL,
  `UnitSellPrice` int(11) NOT NULL DEFAULT '0',
  `MinSellQty` int(11) NOT NULL DEFAULT '0',
  `ProductDesc` char(255) DEFAULT NULL,
  `OnShelf` int(11) NOT NULL DEFAULT '0',
  `AutoOrderConfirmFunctionStatus` int(11) NOT NULL DEFAULT '0',
  `ReservedQty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `product`
--

INSERT INTO `product` (`ProductId`, `OwnerId`, `ProductNameSpec`, `ProductPic`, `SupplierId`, `ProductClassification`, `UnitCost`, `StockQty`, `WarningQty`, `AutoOrderFunction`, `AutoOrderToQty`, `OrderWaitingHour`, `UnitSellPrice`, `MinSellQty`, `ProductDesc`, `OnShelf`, `AutoOrderConfirmFunctionStatus`, `ReservedQty`) VALUES
(100001, 1, '秋刀魚', NULL, 2, 3, 630, 300, 0, 0, NULL, NULL, 1000, 50, '快沒了, 趕快買', 1, 1, NULL),
(100002, 1, '魷魚', NULL, 2, 4, 360, 500, 0, 0, NULL, NULL, 500, 50, NULL, 1, 3, NULL),
(100003, 1, '飛卷板/18KG', NULL, 3, 4, 2520, 200, 100, 1, 500, 3, 3800, 50, '現撈現貨', 0, 4, NULL);

-- --------------------------------------------------------

--
-- 資料表結構 `productclassification`
--

CREATE TABLE `productclassification` (
  `ClassId` int(11) NOT NULL,
  `ClassDesc` char(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `productclassification`
--

INSERT INTO `productclassification` (`ClassId`, `ClassDesc`) VALUES
(1, '螃蟹類'),
(2, '貝類'),
(3, '蝦類'),
(4, '魚類'),
(5, '管魷類');

-- --------------------------------------------------------

--
-- 資料表結構 `systemnoticemessage`
--

CREATE TABLE `systemnoticemessage` (
  `MessageId` int(11) NOT NULL,
  `MessageContent` char(255) NOT NULL,
  `ReceiverId` int(11) NOT NULL,
  `MessageRead` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 傾印資料表的資料 `systemnoticemessage`
--

INSERT INTO `systemnoticemessage` (`MessageId`, `MessageContent`, `ReceiverId`, `MessageRead`) VALUES
(1, '賣家pooh已通過買家duck購物請求 叫貨編號202209200001', 1, 0),
(2, '賣家pooh已取消買家duck購物請求 叫貨編號202209200002', 1, 0),
(3, '使用者duck已向賣家pooh提出購物請求 叫貨編號202209200001', 1, 0),
(4, '使用者duck已向賣家pooh提出購物請求 叫貨編號202209200005', 1, 0);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`AccountId`),
  ADD UNIQUE KEY `Account` (`Account`);

--
-- 資料表索引 `autoorderconfirmfunctionstatus`
--
ALTER TABLE `autoorderconfirmfunctionstatus`
  ADD PRIMARY KEY (`StatusId`);

--
-- 資料表索引 `companyfollowinglist`
--
ALTER TABLE `companyfollowinglist`
  ADD PRIMARY KEY (`BuyerId`,`SellerId`),
  ADD KEY `SellerFollowFk` (`SellerId`);

--
-- 資料表索引 `orderrecord`
--
ALTER TABLE `orderrecord`
  ADD PRIMARY KEY (`OrderId`),
  ADD KEY `cahainstatus2` (`OrderStatus`),
  ADD KEY `cahainbuyid` (`BuyerId`),
  ADD KEY `cahainsellerid` (`SellerId`),
  ADD KEY `cahainsellerpro` (`SellerProductId`);

--
-- 資料表索引 `orderstatus`
--
ALTER TABLE `orderstatus`
  ADD PRIMARY KEY (`StatusId`);

--
-- 資料表索引 `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ProductId`),
  ADD KEY `cahainid` (`SupplierId`),
  ADD KEY `cahainstatus` (`AutoOrderConfirmFunctionStatus`),
  ADD KEY `cahainsellid` (`OwnerId`),
  ADD KEY `cahainclass` (`ProductClassification`);

--
-- 資料表索引 `productclassification`
--
ALTER TABLE `productclassification`
  ADD PRIMARY KEY (`ClassId`);

--
-- 資料表索引 `systemnoticemessage`
--
ALTER TABLE `systemnoticemessage`
  ADD PRIMARY KEY (`MessageId`),
  ADD KEY `NoticeFk` (`ReceiverId`);

--
-- 在傾印的資料表使用自動遞增(AUTO_INCREMENT)
--

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `accounts`
--
ALTER TABLE `accounts`
  MODIFY `AccountId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `autoorderconfirmfunctionstatus`
--
ALTER TABLE `autoorderconfirmfunctionstatus`
  MODIFY `StatusId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `orderrecord`
--
ALTER TABLE `orderrecord`
  MODIFY `OrderId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `orderstatus`
--
ALTER TABLE `orderstatus`
  MODIFY `StatusId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `productclassification`
--
ALTER TABLE `productclassification`
  MODIFY `ClassId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- 使用資料表自動遞增(AUTO_INCREMENT) `systemnoticemessage`
--
ALTER TABLE `systemnoticemessage`
  MODIFY `MessageId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- 已傾印資料表的限制式
--

--
-- 資料表的限制式 `companyfollowinglist`
--
ALTER TABLE `companyfollowinglist`
  ADD CONSTRAINT `BuyerFollowFk` FOREIGN KEY (`BuyerId`) REFERENCES `accounts` (`AccountId`),
  ADD CONSTRAINT `SellerFollowFk` FOREIGN KEY (`SellerId`) REFERENCES `accounts` (`AccountId`);

--
-- 資料表的限制式 `orderrecord`
--
ALTER TABLE `orderrecord`
  ADD CONSTRAINT `cahainbuyid` FOREIGN KEY (`BuyerId`) REFERENCES `accounts` (`AccountId`),
  ADD CONSTRAINT `cahainsellerid` FOREIGN KEY (`SellerId`) REFERENCES `accounts` (`AccountId`),
  ADD CONSTRAINT `cahainsellerpro` FOREIGN KEY (`SellerProductId`) REFERENCES `product` (`ProductId`),
  ADD CONSTRAINT `cahainstatus2` FOREIGN KEY (`OrderStatus`) REFERENCES `orderstatus` (`StatusId`);

--
-- 資料表的限制式 `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `cahainclass` FOREIGN KEY (`ProductClassification`) REFERENCES `productclassification` (`ClassId`),
  ADD CONSTRAINT `cahainid` FOREIGN KEY (`SupplierId`) REFERENCES `accounts` (`AccountId`),
  ADD CONSTRAINT `cahainsellid` FOREIGN KEY (`OwnerId`) REFERENCES `accounts` (`AccountId`),
  ADD CONSTRAINT `cahainstatus` FOREIGN KEY (`AutoOrderConfirmFunctionStatus`) REFERENCES `autoorderconfirmfunctionstatus` (`StatusId`);

--
-- 資料表的限制式 `systemnoticemessage`
--
ALTER TABLE `systemnoticemessage`
  ADD CONSTRAINT `NoticeFk` FOREIGN KEY (`ReceiverId`) REFERENCES `accounts` (`AccountId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
