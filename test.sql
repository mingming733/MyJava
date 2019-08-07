

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

drop table if exists chase_dfr_transaction_fee_detail;
create table chase_dfr_transaction_fee_detail (
    id                  BIGINT NOT NULL AUTO_INCREMENT,
    reportRowId              BIGINT NOT NULL,
    totalFee          VARCHAR(8) NOT NULL,
    category                VARCHAR(5) NOT NULL,
    subCategory      VARCHAR(5) NOT NULL,
    informationReportRowId              BIGINT NOT NULL,
    PRIMARY KEY (id)
)DEFAULT CHARSET=latin1;

INSERT INTO `chase_dfr_transaction_fee_detail` (`id`, `reportRowId`, `totalFee`, `category`, `subCategory`, `informationReportRowId`)
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


INSERT INTO `account_properties` (`id`, `account_id`, `key`, `value`, `version`, `create_time`, `modify_time`)
VALUES
    (1, 36, 'pricing_model', 'merchant_ic_plus', 1, 1442336857, 1442336857),
    (2, 32, 'pricing_model', 'merchant_ic_plus', 1, 1442336857, 1442336857),
    (3, 192, 'pricing_model', 'merchant_ic_plus', 1, 1442336857, 1442336857),
    (4, 156, 'pricing_model', 'merchant_ic_plus', 1, 1452294961, 1452294961),
    (5, 160, 'pricing_model', 'merchant_ic_plus', 1, 1453750528, 1453750528),
    (6, 169, 'pricing_model', 'merchant_ic_plus', 1, 1454007901, 1454007901),
    (7, 170, 'pricing_model', 'merchant_ic_plus', 1, 1454007901, 1454007901),
    (8, 173, 'pricing_model', 'merchant_ic_plus', 1, 1454017175, 1454017175),
    (9, 174, 'pricing_model', 'merchant_ic_plus', 1, 1454017175, 1454017175),
    (10, 178, 'pricing_model', 'merchant_ic_plus', 1, 1454074209, 1454074209),
    (11, 179, 'pricing_model', 'merchant_ic_plus', 1, 1454074209, 1454074209);

INSERT INTO `payments` (`id`, `currency`, `descriptor`, `payment_request_id`, `processor_id`, `amount`, `net`, `fee`, `app_fee`, `effective_gross`, `fee_schedule_id`, `sender_account_id`, `recipient_account_id`, `fee_account_id`, `app_fee_account_id`, `escrow_account_id`, `payer_account_id`, `payee_account_id`, `next_payment_id`, `prev_payment_id`, `cost`, `type`, `status`, `state`, `review`, `direction`, `create_time`, `start_time`, `activity_time`, `processing_date`, `queue_action_time`, `finish_time`, `finance_time`, `stop_time`, `reverse_time`, `deposit_time`, `withdraw_time`, `modify_time`, `user_id`, `ip`, `version`, `payment_method`, `funds_settlement_id`)
VALUES
	(1, 'USD', '', 2, 3, 50000, 50000, 1480, 0, 51480, 1, 32, 32, 35, 32, 0, 34, 32, 0, 0, 0, 1, 256, 3, 0, 1, 1560291960, 1442336855, NULL, NULL, NULL, 1442336857, 1549990800000, NULL, NULL, 1442336857, NULL, 1550012688, 183590906, '', 10, 2, NULL),
	(2, 'USD', '', 3, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443034145, NULL, NULL, NULL, NULL, 1549990800000, 1443034147, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(3, 'USD', '', 4, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443078002, NULL, NULL, NULL, NULL, 1549990800000, 1443078002, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(4, 'USD', '', 5, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443164402, NULL, NULL, NULL, NULL, 1549990800000, 1443164403, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(5, 'USD', '', 6, 19, 50000, 50000, 0, 0, 50000, 1, 36, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443250802, NULL, NULL, NULL, NULL, 1549990800000, 1443250862, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(6, 'USD', '', 7, 19, 50000, 50000, 0, 0, 50000, 1, 36, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443337201, NULL, NULL, NULL, NULL, 1549990800000, 1443337262, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
	(7, 'USD', '', 8, 19, 50000, 50000, 0, 0, 50000, 1, 36, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443423602, NULL, NULL, NULL, NULL, 0, 1443423603, NULL, NULL, NULL, 1443423603, 192320109, '', 8, 0, NULL),
	(8, 'USD', '', 9, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443510002, NULL, NULL, NULL, NULL, 0, 1443510003, NULL, NULL, NULL, 1443510003, 192320109, '', 8, 0, NULL),
	(9, 'USD', '', 10, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443596402, NULL, NULL, NULL, NULL, 0, 1443596403, NULL, NULL, NULL, 1443596403, 192320109, '', 8, 0, NULL),
	(10, 'USD', '', 11, 19, 50000, 50000, 0, 0, 50000, 1, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443682802, NULL, NULL, NULL, NULL, 0, 1443682802, NULL, NULL, NULL, 1443682802, 192320109, '', 8, 0, NULL);



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
