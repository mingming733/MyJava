

-- act72
drop table if exists chase_dfr_transaction_information_detail;
create table chase_dfr_transaction_information_detail (
    id                  BIGINT NOT NULL AUTO_INCREMENT,
    ts_create_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ts_modify_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    reportRowId              BIGINT NOT NULL,
    merchant_order_id          BIGINT NOT NULL,
    method_of_payment                VARCHAR(5) NOT NULL,
    settlementAmount      int(10) unsigned NOT NULL DEFAULT 0,
    settlementCurrency    VARCHAR(5),
    reportHeaderId        VARCHAR(20) NOT NULL,
    entityNumber              BIGINT NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=latin1;
INSERT INTO `chase_dfr_transaction_information_detail` (`id`, `reportRowId`, `merchant_order_id`, `method_of_payment`, `settlementAmount`, `settlementCurrency`, `reportHeaderId`, `entityNumber`)
VALUES
    (1,1, 1, 'VS', 1230, 'USD', 'HFIN00111561629284', 345),
    (2, 2, 2, 'MC', 500, 'USD', 'HFIN00111561629284', 345),
    (3, 3, 3, 'MC', 500, 'USD', 'HFIN00111561629284', 345),
    (4,4, 5, 'VS', 1230, 'USD', 'HFIN00111561629284', 345),
    (5, 5, 6, 'MC', 500, 'USD', 'HFIN00111561629284', 345),
    (6, 6, 7, 'MC', 500, 'USD', 'HFIN00111561629284', 345);

drop table if exists chase_dfr_transaction_fee_information_detail;
create table chase_dfr_transaction_fee_information_detail (
    id                  BIGINT NOT NULL AUTO_INCREMENT,
    reportRowId              BIGINT NOT NULL,
    totalFee          VARCHAR(8) NOT NULL,
    category                VARCHAR(5) NOT NULL,
    subCategory      VARCHAR(5) NOT NULL,
    informationReportRowId              BIGINT NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=latin1;

INSERT INTO `chase_dfr_transaction_fee_information_detail` (`id`, `reportRowId`, `totalFee`, `category`, `subCategory`, `informationReportRowId`)
VALUES
	(1, 1, '0.01', 'IA', 'IC', 1),
	(2, 2, '0.02', 'PEEE', '', 1),
	(3, 3, '0.03', 'IA', 'IC', 1),
	(4, 4, '0.01', 'IA', 'AS', 1),
	(5, 5, '0.02', 'IA', 'IC', 2),
	(6, 6, '0.03', 'IA', 'AS', 2),
	(7, 7, '0.01', 'IA', 'AS', 2),
	(8, 8, '50.02', 'IA', 'AS', 2),
	(9, 1, '1.01', 'IA', 'IC', 3),
	(10, 2, '2.02', 'PEEE', '', 3),
	(11, 3, '3.03', 'IA', 'IC', 3),
	(12, 4, '33.01', 'IA', 'AS', 3),
	(13, 5, '2.02', 'IA', 'IC', 3),
	(14, 6, '2.03', 'IA', 'AS', 3),
	(15, 7, '1.01', 'IA', 'AS', 3),
	(16, 8, '6.02', 'IA', 'AS', 5),
	(17, 4, '1.01', 'IA', 'IC', 5),
	(18, 4, '2.02', 'PEEE', '', 5),
	(19, 5, '3.03', 'IA', 'IC', 5),
	(20, 5, '33.01', 'IA', 'AS', 6),
	(21, 5, '2.02', 'IA', 'IC', 6),
	(22, 6, '2.03', 'IA', 'AS', 6),
	(23, 4, '1.01', 'IA', 'AS', 6),
	(24, 6, '6.02', 'IA', 'AS', 6);

-- end of act72


INSERT INTO `payments` (`id`, `currency`, `descriptor`, `payment_request_id`, `processor_id`, `amount`, `net`, `fee`, `app_fee`, `effective_gross`, `fee_schedule_id`, `sender_account_id`, `recipient_account_id`, `fee_account_id`, `app_fee_account_id`, `escrow_account_id`, `payer_account_id`, `payee_account_id`, `next_payment_id`, `prev_payment_id`, `cost`, `type`, `status`, `state`, `review`, `direction`, `create_time`, `start_time`, `activity_time`, `processing_date`, `queue_action_time`, `finish_time`, `finance_time`, `stop_time`, `reverse_time`, `deposit_time`, `withdraw_time`, `modify_time`, `user_id`, `ip`, `version`, `payment_method`, `funds_settlement_id`)
VALUES
	(489045842, 'USD', '', 2, 3, 50000, 50000, 1480, 0, 51480, 1, 32, 32, 35, 32, 0, 34, 32, 0, 0, 0, 1, 256, 3, 0, 1, 1560291960, 1442336855, NULL, NULL, NULL, 1442336857, 1549990800000, NULL, NULL, 1442336857, NULL, 1550012688, 183590906, '', 10, 2, NULL),
	(489052336, 'USD', '', 3, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443034145, NULL, NULL, NULL, NULL, 1549990800000, 1443034147, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(489033330, 'USD', '', 4, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443078002, NULL, NULL, NULL, NULL, 1549990800000, 1443078002, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(489130310, 'USD', '', 5, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443164402, NULL, NULL, NULL, NULL, 1549990800000, 1443164403, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(489202947, 'USD', '', 6, 19, 50000, 50000, 0, 0, 50000, 1, 36, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443250802, NULL, NULL, NULL, NULL, 1549990800000, 1443250862, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(489192069, 'USD', '', 7, 19, 50000, 50000, 0, 0, 50000, 1, 36, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443337201, NULL, NULL, NULL, NULL, 1549990800000, 1443337262, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(489200747, 'USD', '', 8, 19, 50000, 50000, 0, 0, 50000, 1, 36, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443423602, NULL, NULL, NULL, NULL, 0, 1443423603, NULL, NULL, NULL, 1443423603, 192320109, '', 8, 0, NULL),
	(484430136, 'USD', '', 9, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443510002, NULL, NULL, NULL, NULL, 0, 1443510003, NULL, NULL, NULL, 1443510003, 192320109, '', 8, 0, NULL),
	(484311607, 'USD', '', 10, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443596402, NULL, NULL, NULL, NULL, 0, 1443596403, NULL, NULL, NULL, 1443596403, 192320109, '', 8, 0, NULL),
	(489038651, 'USD', '', 11, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443682802, NULL, NULL, NULL, NULL, 0, 1443682802, NULL, NULL, NULL, 1443682802, 192320109, '', 8, 0, NULL);


update `mythic-crane-708.s_lanai.payments`
set create_time = 1562545668
where id in 	(489045842, 489052336, 489033330, 489130310, 489202947, 489192069, 489200747, 484430136, 484311607, 489038651);


drop table if exists chase_dfr_header;
create table chase_dfr_header (
    id                   VARCHAR(20) NOT NULL,
    reportDateFrom             DATE NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=latin1;

INSERT INTO `chase_dfr_header` (`id`, `reportDateFrom`)
VALUES
    ('HFIN00111561629284', '2019-06-15'),
    ('HFIN00111561629285', '2019-06-15');

-- fin11
drop table if exists chase_dfr_service_charge;
create table chase_dfr_service_charge (
    id                  BIGINT NOT NULL AUTO_INCREMENT,
    ts_create_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ts_modify_time      TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    entityNumber              BIGINT NOT NULL,
    totalCharge          BIGINT NOT NULL,
    mop                VARCHAR(5) NOT NULL,
    amount        BIGINT NOT NULL      DEFAULT 0,
    reportHeaderId        VARCHAR(20) NOT NULL,
    category                VARCHAR(5) NOT NULL,
    subCategory      VARCHAR(5) NOT NULL,
    actionType        VARCHAR(5) NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=latin1;


INSERT INTO `chase_dfr_service_charge` (`id`, `ts_create_time`, `ts_modify_time`, `entityNumber`, `totalCharge`, `mop`, `amount`, `reportHeaderId`, `category`, `subCategory`, `actionType`)
VALUES
    (2, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 15, 'VS', 15000, 'HFIN00111561629285', 'IA', 'IC', 'S'),
    (3, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 32, 'VS', 15000, 'HFIN00111561629285', 'IA', 'AS', 'S'),
    (4, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 33, 'VS', 15000, 'HFIN00111561629285', 'IA', 'IC', 'S'),
    (5, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 21, 'VS', 11000, 'HFIN00111561629285', 'IA', 'AS', 'S'),
    (6, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 10, 'VS', 22000, 'HFIN00111561629285', 'IA', 'AS', 'S');
-- end of fin11
INSERT INTO `chase_dfr_header` (`id`, `reportDateFrom`)
VALUES
    ('HFIN00111561629285', '2019-06-15');

-- fee_schedule

drop table if exists fee_schedule;
CREATE TABLE `fee_schedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ts_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ts_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `max_fee_amount` int(10) unsigned NOT NULL DEFAULT '0',
  `min_fee_amount` int(10) unsigned NOT NULL DEFAULT '0',
  `fixed_fee_amount` int(10) unsigned NOT NULL DEFAULT '0',
  `basis_point` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `max_fee_amount` (`max_fee_amount`,`min_fee_amount`,`fixed_fee_amount`,`basis_point`),
  KEY `idx_ts_create_time` (`ts_create_time`),
  KEY `idx_ts_modify_time` (`ts_modify_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `fee_schedule` (`id`, `ts_create_time`, `ts_modify_time`, `max_fee_amount`, `min_fee_amount`, `fixed_fee_amount`, `basis_point`)
VALUES
    (1, '2019-07-15 22:32:22', '2019-07-15 22:32:40', 0, 0, 30, 21),
    (2, '2019-07-15 22:32:22', '2019-07-15 22:32:40', 0, 0, 50, 11);


drop table if exists entity_fee_schedule_mapping;
CREATE TABLE `entity_fee_schedule_mapping` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ts_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ts_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `entity_id` varchar(256) NOT NULL,
  `currency` char(3) NOT NULL,
  `entity_type` varchar(20) NOT NULL,
  `fee_schedule_id` int(10) unsigned NOT NULL,
  `fee_schedule_type` varchar(20) NOT NULL,
  `lower_threshold` int(10) unsigned NOT NULL,
  `upper_threshold` int(10) unsigned NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_entity_fee_schedule` (`entity_id`,`currency`,`entity_type`,`fee_schedule_type`),
  KEY `idx_ts_create_time` (`ts_create_time`),
  KEY `idx_ts_modify_time` (`ts_modify_time`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `entity_fee_schedule_mapping` (`id`, `ts_create_time`, `ts_modify_time`, `entity_id`, `currency`, `entity_type`, `fee_schedule_id`, `fee_schedule_type`, `lower_threshold`, `upper_threshold`, `enabled`)
VALUES
	(1, '2019-08-06 23:27:54', '2019-08-06 23:28:25', '1', 'USD', 'V2', 1, 'ic_cc', 0, 0, 1),
	(2, '2019-08-06 23:29:21', '2019-08-06 23:29:21', 'd1fa5b4f-291c-4349-87d6-f2747ade7e32', 'USD', 'V3', 1, 'ic_cc', 0, 0, 1);

Drop table if exists `shadow_group_mapping`;
CREATE TABLE `shadow_group_mapping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mapping_object_type` varchar(50) CHARACTER SET utf8 NOT NULL,
  `mapping_object_id` varchar(255) CHARACTER SET utf8 NOT NULL,
  `group_id` bigint(20) unsigned NOT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `modify_time` bigint(20) DEFAULT NULL,
  `version` bigint(20) DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `v3_mapping_unique` (`mapping_object_type`,`mapping_object_id`),
  KEY `idx_group_id` (`group_id`),
  KEY `idx_create_time` (`create_time`),
  KEY `idx_modify_time` (`modify_time`)
) ENGINE=InnoDB AUTO_INCREMENT=114716 DEFAULT CHARSET=latin1;

INSERT INTO `shadow_group_mapping` (`id`, `mapping_object_type`, `mapping_object_id`, `group_id`, `create_time`, `modify_time`, `version`)
VALUES
	(11470, 'merchant_account', 'd1fa5b4f-291c-4349-87d6-f2747ade7e32', 2, 1518435809, 1518435810, 1);


INSERT INTO `groups` (`id`, `name`, `description`, `founder_id`, `photo_id`, `account_id`, `primary_bank_account_id`, `parent_id`, `preferences`, `status`, `create_time`, `vanity_url`, `vanity_url_normalized`, `data`, `app_id`, `theme_id`, `gaq_domains`, `settings`, `financial_admin_id`, `reference_id`, `kyc_id`, `modify_time`, `version`, `expire_time`, `disablement_time`, `country`)
VALUES
    (1, 'Merchant Kangaroo US 21550671572.account.US', 'Merchant Kangaroo US 21550671572.account.US', 145612538, 0, 32, NULL, NULL, 'a:0:{}', 33, 1550671572, NULL, NULL, 'O:8:\"stdClass\":1:{s:16:\"invitation_count\";N;}', 24646, 0, 'N;', 159, 145612538, NULL, 195374, 1550671572, 4, NULL, NULL, 'US'),
    (2, 'CA business', 'CA business', 46776263, 0, 36, NULL, NULL, 'a:2:{s:5:\"email\";a:0:{}s:11:\"permissions\";a:2:{s:6:\"public\";a:4:{s:6:\"donate\";b:0;s:4:\"join\";b:0;s:17:\"requestInvitation\";b:1;s:4:\"view\";b:1;}s:8:\"nonAdmin\";a:7:{s:11:\"contactInfo\";b:1;s:7:\"history\";b:1;s:14:\"memberActivity\";b:1;s:7:\"members\";b:1;s:8:\"requests\";b:1;s:6:\"invite\";b:0;s:11:\"viewBalance\";b:1;}}}', 4354, 1520351638, NULL, NULL, 'O:8:\"stdClass\":1:{s:16:\"invitation_count\";N;}', 183324, 0, 'N;', 159, 46776263, NULL, 36792, 1530886517, 8, NULL, NULL, 'CA');
----big query
  INSERT INTO `mythic-crane-708.s_lanai.fee_schedule` (`id`, `ts_create_time`, `ts_modify_time`, `max_fee_amount`, `min_fee_amount`, `fixed_fee_amount`, `basis_point`)
VALUES
	(1, '2019-07-15 22:32:22', '2019-07-15 22:32:40', 0, 0, 30, 21),
	(2, '2019-07-15 22:32:22', '2019-07-15 22:32:40', 0, 0, 50, 11);


-- dorado history

drop table if exists entity_fee_schedule_mapping_history;

CREATE TABLE `entity_fee_schedule_mapping_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ts_create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ts_modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `entity_id` varchar(256) NOT NULL,
  `currency` char(3) NOT NULL,
  `entity_type` varchar(20) NOT NULL,
  `fee_schedule_id` int(10) unsigned NOT NULL,
  `fee_schedule_type` varchar(20) NOT NULL,
  `lower_threshold` int(10) unsigned NOT NULL,
  `upper_threshold` int(10) unsigned NOT NULL,
  `operation` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_entity_fee_schedule` (`entity_id`,`currency`,`entity_type`,`fee_schedule_type`),
  KEY `idx_ts_create_time` (`ts_create_time`),
  KEY `idx_ts_modify_time` (`ts_modify_time`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=latin1;

INSERT INTO `entity_fee_schedule_mapping_history` (`id`, `ts_create_time`, `ts_modify_time`, `entity_id`, `currency`, `entity_type`, `fee_schedule_id`, `fee_schedule_type`, `lower_threshold`, `upper_threshold`, `operation`)
VALUES
	(1, '2019-08-13 20:17:26', '2019-08-13 20:17:26', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(2, '2019-08-13 20:21:29', '2019-08-13 20:21:29', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'DISABLE'),
	(3, '2019-08-13 20:21:29', '2019-08-13 20:21:29', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(4, '2019-08-13 20:25:53', '2019-08-13 20:25:53', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'DISABLE'),
	(5, '2019-08-13 20:25:53', '2019-08-13 20:25:53', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(6, '2019-08-13 20:29:19', '2019-08-13 20:29:19', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'DISABLE'),
	(7, '2019-08-13 20:29:19', '2019-08-13 20:29:19', 'abc-123', 'USD', 'V2_GROUP', 8, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(8, '2019-08-13 20:36:03', '2019-08-13 20:36:03', 'abc-123', 'USD', 'V2_GROUP', 8, 'CC_IC', 0, 2147483647, 'DISABLE'),
	(9, '2019-08-13 20:36:04', '2019-08-13 20:36:04', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(10, '2019-08-13 21:07:28', '2019-08-13 21:07:28', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 0, 2147483647, 'DISABLE'),
	(11, '2019-08-13 21:07:28', '2019-08-13 21:07:28', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'ENABLE'),
	(12, '2019-08-13 21:09:12', '2019-08-13 21:09:12', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'DISABLE'),
	(13, '2019-08-13 21:09:12', '2019-08-13 21:09:12', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(14, '2019-08-13 21:15:44', '2019-08-13 21:15:44', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 0, 2147483647, 'DISABLE'),
	(15, '2019-08-13 21:15:44', '2019-08-13 21:15:44', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'ENABLE'),
	(16, '2019-08-13 23:09:55', '2019-08-13 23:09:55', '354580ff-cfe3-4631-a0cf-3fe57abc5b19', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(17, '2019-08-13 23:09:55', '2019-08-13 23:09:55', '354580ff-cfe3-4631-a0cf-3fe57abc5b19', 'USD', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(18, '2019-08-13 23:16:02', '2019-08-13 23:16:02', '4ec9e3e4-482e-493a-b5bb-f9d2f8feb5d2', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(19, '2019-08-13 23:16:03', '2019-08-13 23:16:03', '4ec9e3e4-482e-493a-b5bb-f9d2f8feb5d2', 'USD', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(20, '2019-08-13 23:57:10', '2019-08-13 23:57:10', '8320ceed-d3c2-43fb-bfcd-51c78a62e8eb', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(21, '2019-08-13 23:57:11', '2019-08-13 23:57:11', '8320ceed-d3c2-43fb-bfcd-51c78a62e8eb', 'USD', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(22, '2019-08-14 00:25:56', '2019-08-14 00:25:56', 'bbc09cbf-27a9-4ec7-8851-7b75e25523dc', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(23, '2019-08-14 00:25:56', '2019-08-14 00:25:56', 'bbc09cbf-27a9-4ec7-8851-7b75e25523dc', 'USD', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(24, '2019-08-14 00:25:57', '2019-08-14 00:25:57', 'bbc09cbf-27a9-4ec7-8851-7b75e25523dc', 'GBP', 'V3_MERCHANT', 13, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(25, '2019-08-14 00:25:58', '2019-08-14 00:25:58', 'bbc09cbf-27a9-4ec7-8851-7b75e25523dc', 'GBP', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(26, '2019-08-14 21:00:16', '2019-08-14 21:00:16', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'DISABLE'),
	(27, '2019-08-14 21:00:16', '2019-08-14 21:00:16', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'ENABLE'),
	(28, '2019-08-14 21:14:45', '2019-08-14 21:14:45', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'DISABLE'),
	(29, '2019-08-14 21:14:45', '2019-08-14 21:14:45', 'abc-123', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'ENABLE'),
	(30, '2019-08-14 21:31:24', '2019-08-14 21:31:24', '3221597a-79f5-4320-b803-107ed0b1f14d', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(31, '2019-08-14 21:31:25', '2019-08-14 21:31:25', '3221597a-79f5-4320-b803-107ed0b1f14d', 'USD', 'V3_MERCHANT', 14, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(32, '2019-08-14 21:31:25', '2019-08-14 21:31:25', '3221597a-79f5-4320-b803-107ed0b1f14d', 'GBP', 'V3_MERCHANT', 15, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(33, '2019-08-14 21:31:26', '2019-08-14 21:31:26', '3221597a-79f5-4320-b803-107ed0b1f14d', 'GBP', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(34, '2019-08-14 22:51:16', '2019-08-14 22:51:16', '692cc1d3-762a-4893-9f58-74763c5b00f0', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(35, '2019-08-14 22:51:18', '2019-08-14 22:51:18', '692cc1d3-762a-4893-9f58-74763c5b00f0', 'USD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(36, '2019-08-14 22:51:20', '2019-08-14 22:51:20', '692cc1d3-762a-4893-9f58-74763c5b00f0', 'GBP', 'V3_MERCHANT', 17, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(37, '2019-08-14 22:51:21', '2019-08-14 22:51:21', '692cc1d3-762a-4893-9f58-74763c5b00f0', 'GBP', 'V3_MERCHANT', 12, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(38, '2019-08-15 18:57:18', '2019-08-15 18:57:18', '55f637d1-33a5-4a8f-bf6f-06caa148ebcb', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(39, '2019-08-15 18:57:18', '2019-08-15 18:57:18', '55f637d1-33a5-4a8f-bf6f-06caa148ebcb', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(40, '2019-08-15 21:49:40', '2019-08-15 21:49:40', 'a1db5d9d-267a-4fc4-a7b2-7e488c312140', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(41, '2019-08-15 21:49:40', '2019-08-15 21:49:40', 'a1db5d9d-267a-4fc4-a7b2-7e488c312140', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(42, '2019-08-15 21:59:02', '2019-08-15 21:59:02', 'dd51d534-f793-4668-a77e-ba6f6ee89481', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(43, '2019-08-15 21:59:02', '2019-08-15 21:59:02', 'dd51d534-f793-4668-a77e-ba6f6ee89481', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(44, '2019-08-15 22:02:58', '2019-08-15 22:02:58', 'b4d5878b-f01b-4e8f-bdeb-6de25e5739e4', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(45, '2019-08-15 22:02:58', '2019-08-15 22:02:58', 'b4d5878b-f01b-4e8f-bdeb-6de25e5739e4', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(46, '2019-08-15 22:05:06', '2019-08-15 22:05:06', 'f10ebf8c-6a1a-4295-b95a-69e4e3770d04', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(47, '2019-08-15 22:05:06', '2019-08-15 22:05:06', 'f10ebf8c-6a1a-4295-b95a-69e4e3770d04', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(48, '2019-08-15 22:22:21', '2019-08-15 22:22:21', 'ce62b28a-b465-4996-b24b-de2006d43198', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(49, '2019-08-15 22:22:21', '2019-08-15 22:22:21', 'ce62b28a-b465-4996-b24b-de2006d43198', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(50, '2019-08-15 22:23:07', '2019-08-15 22:23:07', 'e2192976-779c-4a52-a362-8797340aeb36', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(51, '2019-08-15 22:23:07', '2019-08-15 22:23:07', 'e2192976-779c-4a52-a362-8797340aeb36', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(52, '2019-08-15 22:23:52', '2019-08-15 22:23:52', '11293b28-5793-497b-a5bf-f13899c6d738', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(53, '2019-08-15 22:23:52', '2019-08-15 22:23:52', '11293b28-5793-497b-a5bf-f13899c6d738', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(54, '2019-08-15 22:37:13', '2019-08-15 22:37:13', 'd3039c80-35de-45b5-bf48-b53dc5bc65e9', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(55, '2019-08-15 22:37:13', '2019-08-15 22:37:13', 'd3039c80-35de-45b5-bf48-b53dc5bc65e9', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(56, '2019-08-15 22:46:49', '2019-08-15 22:46:49', 'e36ad244-3a9a-47ad-89fd-f98d2a446001', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(57, '2019-08-15 22:46:49', '2019-08-15 22:46:49', 'e36ad244-3a9a-47ad-89fd-f98d2a446001', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(58, '2019-08-15 22:49:14', '2019-08-15 22:49:14', 'c28cce21-6d94-4b9b-bbb8-adb5ad1d99ae', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(59, '2019-08-15 22:49:15', '2019-08-15 22:49:15', 'c28cce21-6d94-4b9b-bbb8-adb5ad1d99ae', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(60, '2019-08-15 22:53:14', '2019-08-15 22:53:14', 'fb95877f-3949-459b-bd9d-19408328a30a', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(61, '2019-08-15 22:53:14', '2019-08-15 22:53:14', 'fb95877f-3949-459b-bd9d-19408328a30a', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(62, '2019-08-15 22:59:36', '2019-08-15 22:59:36', '5e0cf571-3bc3-462d-89ec-596c1bdd4594', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(63, '2019-08-15 22:59:36', '2019-08-15 22:59:36', '5e0cf571-3bc3-462d-89ec-596c1bdd4594', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(64, '2019-08-15 23:07:27', '2019-08-15 23:07:27', 'fabfac0c-3b50-4018-bddc-803c8a0b085c', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(65, '2019-08-15 23:07:27', '2019-08-15 23:07:27', 'fabfac0c-3b50-4018-bddc-803c8a0b085c', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(66, '2019-08-15 23:08:43', '2019-08-15 23:08:43', 'd7da05d3-1551-41f5-9056-5c76e53a3016', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(67, '2019-08-15 23:08:43', '2019-08-15 23:08:43', 'd7da05d3-1551-41f5-9056-5c76e53a3016', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(68, '2019-08-15 23:09:32', '2019-08-15 23:09:32', '94781090-a7ae-45fc-86e8-2eb6b88fc3a8', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(69, '2019-08-15 23:09:32', '2019-08-15 23:09:32', '94781090-a7ae-45fc-86e8-2eb6b88fc3a8', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(70, '2019-08-16 00:21:52', '2019-08-16 00:21:52', '3d647a83-c9b5-47d9-ae28-cf02cafa3939', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(71, '2019-08-16 17:03:49', '2019-08-16 17:03:49', 'abf3403f-ad62-479e-a336-b4184f9ad5c4', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(72, '2019-08-16 17:03:49', '2019-08-16 17:03:49', 'abf3403f-ad62-479e-a336-b4184f9ad5c4', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(73, '2019-08-16 17:22:58', '2019-08-16 17:22:58', 'c2485b48-fd9f-4de1-bd27-21d4851ed7c2', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(74, '2019-08-16 17:22:58', '2019-08-16 17:22:58', 'c2485b48-fd9f-4de1-bd27-21d4851ed7c2', 'CAD', 'V3_MERCHANT', 16, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(75, '2019-08-16 17:28:06', '2019-08-16 17:28:06', '641d4d33-d2f2-48d7-bc7e-7bf6f492d06b', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(76, '2019-08-16 17:28:06', '2019-08-16 17:28:06', '641d4d33-d2f2-48d7-bc7e-7bf6f492d06b', 'CAD', 'V3_MERCHANT', 18, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(77, '2019-08-16 17:38:50', '2019-08-16 17:38:50', 'aed7fc6d-1ceb-4669-81d7-6030db506b90', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(78, '2019-08-16 17:38:50', '2019-08-16 17:38:50', 'aed7fc6d-1ceb-4669-81d7-6030db506b90', 'CAD', 'V3_MERCHANT', 18, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(79, '2019-08-16 20:24:35', '2019-08-16 20:24:35', '88a8bd98-608e-4b20-a0a8-72501bd33145', 'CAD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(80, '2019-08-16 20:24:35', '2019-08-16 20:24:35', '88a8bd98-608e-4b20-a0a8-72501bd33145', 'CAD', 'V3_MERCHANT', 18, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(81, '2019-08-16 20:39:20', '2019-08-16 20:39:20', '5d04e10d-41c2-49e9-8fda-99e2c55cb81f', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(82, '2019-08-16 20:39:20', '2019-08-16 20:39:20', '5d04e10d-41c2-49e9-8fda-99e2c55cb81f', 'USD', 'V3_MERCHANT', 18, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(83, '2019-08-16 22:10:56', '2019-08-16 22:10:56', 'bc98907e-cd34-489b-8c83-ce03a87224c4', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(84, '2019-08-16 22:10:56', '2019-08-16 22:10:56', 'bc98907e-cd34-489b-8c83-ce03a87224c4', 'USD', 'V3_MERCHANT', 18, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(85, '2019-08-16 22:20:39', '2019-08-16 22:20:39', '51c95b36-256c-40d2-b8d1-f82bd5c45c36', 'USD', 'V3_MERCHANT', 11, 'CC_IC', 0, 2147483647, 'ENABLE'),
	(86, '2019-08-16 22:20:39', '2019-08-16 22:20:39', '51c95b36-256c-40d2-b8d1-f82bd5c45c36', 'USD', 'V3_MERCHANT', 18, 'ACH_T1', 0, 2147483647, 'ENABLE'),
	(87, '2019-08-19 18:18:21', '2019-08-19 18:18:21', 'abc-124', 'USD', 'V2_GROUP', 9, 'CC_IC', 1, 2147483647, 'ENABLE'),
	(88, '2019-08-19 18:18:21', '2019-08-19 18:18:21', 'abc-124', 'GBP', 'V3_MERCHANT', 9, 'CC_CP', 1, 2147483647, 'ENABLE');
