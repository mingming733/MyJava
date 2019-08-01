

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
    (3, 2, 3, 'MC', 500, 'USD', 'HFIN00111561629284', 345);


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

INSERT INTO `chase_dfr_transaction_fee_detail` (`id`, `reportRowId`,  `category`, `subCategory`, `totalFee`, `informationReportRowId`)
VALUES
    (1, 1, 'IA', 'IC', '0.01', 1),
    (2, 2, 'PEEE', '', '0.02', 1),
    (3, 3, 'IA', 'IC', '0.03', 1),
    (4, 4, 'IA', 'AS', '0.01', 1),
    (5, 5, 'IA', 'IC', '0.02', 2),
    (6, 6, 'IA', 'AS', '0.03', 2),
    (7, 7, 'IA', 'AS', '0.01', 2),
    (8, 8, 'IA', 'AS', '50.02', 2),
    (9, 1, 'IA', 'IC', '1.01', 3),
    (10, 2, 'PEEE', '', '2.02', 3),
    (11, 3, 'IA', 'IC', '3.03', 3),
    (12, 4, 'IA', 'AS', '33.01', 3),
    (13, 5, 'IA', 'IC', '2.02', 3),
    (14, 6, 'IA', 'AS', '2.03', 3),
    (15, 7, 'IA', 'AS', '1.01', 3),
    (16, 8, 'IA', 'AS', '6.02', 3);
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
    (1, 'USD', '', 2, 3, 50000, 50000, 1480, 0, 51480, 21, 33, 32, 35, 32, 0, 34, 32, 0, 0, 0, 1, 256, 3, 0, 1, 1560291960, 1442336855, NULL, NULL, NULL, 1442336857, 1549990800000, NULL, NULL, 1442336857, NULL, 1550012688, 183590906, '', 10, 2, NULL),
    (2, 'USD', '', 3, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 4, 256, 6, 0, 2, 1560291960, 1443034145, NULL, NULL, NULL, NULL, 1549990800000, 1443034147, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
    (3, 'USD', '', 4, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443078002, NULL, NULL, NULL, NULL, 1549990800000, 1443078002, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
    (4, 'USD', '', 5, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443164402, NULL, NULL, NULL, NULL, 1549990800000, 1443164403, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
    (5, 'USD', '', 6, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443250802, NULL, NULL, NULL, NULL, 1549990800000, 1443250862, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
    (6, 'USD', '', 7, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443337201, NULL, NULL, NULL, NULL, 1549990800000, 1443337262, NULL, NULL, NULL, 1550012688, 192320109, '', 10, 0, NULL),
    (7, 'USD', '', 8, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443423602, NULL, NULL, NULL, NULL, 0, 1443423603, NULL, NULL, NULL, 1443423603, 192320109, '', 8, 0, NULL),
    (8, 'USD', '', 9, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443510002, NULL, NULL, NULL, NULL, 0, 1443510003, NULL, NULL, NULL, 1443510003, 192320109, '', 8, 0, NULL),
    (9, 'USD', '', 10, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443596402, NULL, NULL, NULL, NULL, 0, 1443596403, NULL, NULL, NULL, 1443596403, 192320109, '', 8, 0, NULL),
    (10, 'USD', '', 11, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443682802, NULL, NULL, NULL, NULL, 0, 1443682802, NULL, NULL, NULL, 1443682802, 192320109, '', 8, 0, NULL),
    (11, 'USD', '', 12, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443769202, NULL, NULL, NULL, NULL, 0, 1443769203, NULL, NULL, NULL, 1443769203, 192320109, '', 8, 0, NULL),
    (12, 'USD', '', 13, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443855602, NULL, NULL, NULL, NULL, 0, 1443855661, NULL, NULL, NULL, 1443855661, 192320109, '', 8, 0, NULL),
    (13, 'USD', '', 14, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1443942002, NULL, NULL, NULL, NULL, 0, 1443942061, NULL, NULL, NULL, 1443942061, 192320109, '', 8, 0, NULL),
    (14, 'USD', '', 15, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444028402, NULL, NULL, NULL, NULL, 0, 1444028462, NULL, NULL, NULL, 1444028462, 192320109, '', 8, 0, NULL),
    (15, 'USD', '', 16, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444114802, NULL, NULL, NULL, NULL, 0, 1444115582, NULL, NULL, NULL, 1444115582, 192320109, '', 8, 0, NULL),
    (16, 'USD', '', 17, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444201202, NULL, NULL, NULL, NULL, 0, 1444201202, NULL, NULL, NULL, 1444201202, 192320109, '', 8, 0, NULL),
    (17, 'USD', '', 18, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444287602, NULL, NULL, NULL, NULL, 0, 1444287602, NULL, NULL, NULL, 1444287602, 192320109, '', 8, 0, NULL),
    (18, 'USD', '', 19, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444374002, NULL, NULL, NULL, NULL, 0, 1444374003, NULL, NULL, NULL, 1444374003, 192320109, '', 8, 0, NULL),
    (19, 'USD', '', 20, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444460401, NULL, NULL, NULL, NULL, 0, 1444460462, NULL, NULL, NULL, 1444460462, 192320109, '', 8, 0, NULL),
    (20, 'USD', '', 21, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444546802, NULL, NULL, NULL, NULL, 0, 1444546802, NULL, NULL, NULL, 1444546802, 192320109, '', 8, 0, NULL),
    (21, 'USD', '', 22, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444633201, NULL, NULL, NULL, NULL, 0, 1444633202, NULL, NULL, NULL, 1444633202, 192320109, '', 8, 0, NULL),
    (22, 'USD', '', 23, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444719601, NULL, NULL, NULL, NULL, 0, 1444719602, NULL, NULL, NULL, 1444719602, 192320109, '', 8, 0, NULL),
    (23, 'USD', '', 24, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444806002, NULL, NULL, NULL, NULL, 0, 1444806782, NULL, NULL, NULL, 1444806782, 192320109, '', 8, 0, NULL),
    (24, 'USD', '', 25, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444892401, NULL, NULL, NULL, NULL, 0, 1444892402, NULL, NULL, NULL, 1444892402, 192320109, '', 8, 0, NULL),
    (25, 'USD', '', 26, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1444978802, NULL, NULL, NULL, NULL, 0, 1444978861, NULL, NULL, NULL, 1444978861, 192320109, '', 8, 0, NULL),
    (26, 'USD', '', 27, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1446420271, NULL, NULL, NULL, NULL, 0, 1446420273, NULL, NULL, NULL, 1446420273, 192320109, '', 8, 0, NULL),
    (27, 'USD', '', 28, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1446750496, NULL, NULL, NULL, NULL, 0, 1446750498, NULL, NULL, NULL, 1446750498, 192320109, '', 8, 0, NULL),
    (28, 'USD', '', 29, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1446796801, NULL, NULL, NULL, NULL, 0, 1446796862, NULL, NULL, NULL, 1446796862, 192320109, '', 8, 0, NULL),
    (29, 'USD', '', 30, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1446883202, NULL, NULL, NULL, NULL, 0, 1446883203, NULL, NULL, NULL, 1446883203, 192320109, '', 8, 0, NULL),
    (30, 'USD', '', 31, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1446969601, NULL, NULL, NULL, NULL, 0, 1446969662, NULL, NULL, NULL, 1446969662, 192320109, '', 8, 0, NULL),
    (31, 'USD', '', 32, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447056001, NULL, NULL, NULL, NULL, 0, 1447056002, NULL, NULL, NULL, 1447056002, 192320109, '', 8, 0, NULL),
    (32, 'USD', '', 33, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447142402, NULL, NULL, NULL, NULL, 0, 1447142403, NULL, NULL, NULL, 1447142403, 192320109, '', 8, 0, NULL),
    (33, 'USD', '', 34, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447228802, NULL, NULL, NULL, NULL, 0, 1447228802, NULL, NULL, NULL, 1447228802, 192320109, '', 8, 0, NULL),
    (34, 'USD', '', 35, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447315202, NULL, NULL, NULL, NULL, 0, 1447315203, NULL, NULL, NULL, 1447315203, 192320109, '', 8, 0, NULL),
    (35, 'USD', '', 36, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447401601, NULL, NULL, NULL, NULL, 0, 1447401602, NULL, NULL, NULL, 1447401602, 192320109, '', 8, 0, NULL),
    (36, 'USD', '', 37, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447488002, NULL, NULL, NULL, NULL, 0, 1447488061, NULL, NULL, NULL, 1447488061, 192320109, '', 8, 0, NULL),
    (37, 'USD', '', 38, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447574402, NULL, NULL, NULL, NULL, 0, 1447574461, NULL, NULL, NULL, 1447574461, 192320109, '', 8, 0, NULL),
    (38, 'USD', '', 39, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447660802, NULL, NULL, NULL, NULL, 0, 1447660802, NULL, NULL, NULL, 1447660802, 192320109, '', 8, 0, NULL),
    (39, 'USD', '', 40, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1560291960, 1447747201, NULL, NULL, NULL, NULL, 0, 1447747202, NULL, NULL, NULL, 1447747202, 192320109, '', 8, 0, NULL),
    (40, 'USD', '', 41, 19, 50000, 50000, 0, 0, 50000, 4, 32, 36, 35, 0, 0, 32, 36, 0, 0, 0, 1, 256, 6, 0, 2, 1558828494, 1447864801, NULL, NULL, NULL, NULL, 0, 1447864803, NULL, NULL, NULL, 1447864803, 192320109, '', 8, 0, NULL);


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
    PRIMARY KEY (id)
)DEFAULT CHARSET=latin1;


INSERT INTO `chase_dfr_service_charge` (`id`, `ts_create_time`, `ts_modify_time`, `entityNumber`, `totalCharge`, `mop`, `amount`, `reportHeaderId`, `category`, `subCategory`)
VALUES
    (2, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 15, 'VS', 15000, 'HFIN00111561629285', 'IA', 'IC'),
    (3, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 32, 'VS', 15000, 'HFIN00111561629285', 'IA', 'AS'),
    (4, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 33, 'VS', 15000, 'HFIN00111561629285', 'IA', 'IC'),
    (5, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 21, 'VS', 11000, 'HFIN00111561629285', 'IA', 'AS'),
    (6, '2019-07-10 05:00:56', '2019-07-10 05:00:56', 345, 10, 'VS', 22000, 'HFIN00111561629285', 'IA', 'AS');
-- end of fin11
INSERT INTO `chase_dfr_header` (`id`, `reportDateFrom`)
VALUES
    ('HFIN00111561629285', '2019-06-15');

-- fee_schedule

drop table if exists fee_schedule;
create table fee_schedule (
    id                      VARCHAR(5) NOT NULL,
    ts_create_time          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ts_modify_time          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    max_fee_amount          INTEGER unsigned NOT NULL DEFAULT 0,
    min_fee_amount          INTEGER unsigned NOT NULL DEFAULT 0,
    fixed_fee_amount        INTEGER unsigned NOT NULL DEFAULT 0,
    basis_point             INTEGER unsigned NOT NULL DEFAULT 0,  -- 100 is 1%

    PRIMARY KEY (id),
    KEY idx_ts_create_time(ts_create_time),
    KEY idx_ts_modify_time(ts_modify_time)

) CHARACTER SET latin1;

INSERT INTO `fee_schedule` (`id`, `ts_create_time`, `ts_modify_time`, `max_fee_amount`, `min_fee_amount`, `fixed_fee_amount`, `basis_point`)
VALUES
    (1, '2019-07-15 22:32:22', '2019-07-15 22:32:40', 0, 0, 30, 21),
    (2, '2019-07-15 22:32:22', '2019-07-15 22:32:40', 0, 0, 50, 11);


create table merchant_fee_schedule_mapping (
    id                      BIGINT NOT NULL AUTO_INCREMENT,
    ts_create_time          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ts_modify_time          TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    merchant_id             VARCHAR(256) NOT NULL,                -- V2 group id or V3 merchant id
    currency                CHAR(3) NOT NULL,
    type                    INTEGER NOT NULL,                     -- type of merchant: V2/V3
    cc_ic                   INTEGER unsigned NOT NULL DEFAULT 0,
    cc_cp                   INTEGER unsigned NOT NULL DEFAULT 0,
    cc_cp_amex              INTEGER unsigned NOT NULL DEFAULT 0,
    cc_cnp                  INTEGER unsigned NOT NULL DEFAULT 0,
    cc_cnp_amex             INTEGER unsigned NOT NULL DEFAULT 0,
    intl_extra              INTEGER unsigned NOT NULL DEFAULT 0,  -- add ons when sender currency different from recipient currency
    ach_t1                  INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t2                  INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t3                  INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t4                  INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t1_threshold        INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t2_threshold        INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t3_threshold        INTEGER unsigned NOT NULL DEFAULT 0,
    ach_t4_threshold        INTEGER unsigned NOT NULL DEFAULT 0,

    PRIMARY KEY (id),
    KEY idx_ts_create_time (ts_create_time),
    KEY idx_ts_modify_time (ts_modify_time)
) CHARACTER SET latin1;

INSERT INTO `merchant_fee_schedule_mapping` (`id`, `ts_create_time`, `ts_modify_time`, `merchant_id`, `currency`, `type`, `cc_ic`, `cc_cp`, `cc_cp_amex`, `cc_cnp`, `cc_cnp_amex`, `intl_extra`, `ach_t1`, `ach_t2`, `ach_t3`, `ach_t4`, `ach_t1_threshold`, `ach_t2_threshold`, `ach_t3_threshold`, `ach_t4_threshold`)
VALUES
    (1, '2019-07-15 21:16:58', '2019-07-15 21:18:02', 'd1fa5b4f-291c-4349-87d6-f2747ade7e32', 'USD', 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
    (2, '2019-07-15 21:16:58', '2019-07-15 21:18:02', '2', 'USD', 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

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
    (11470, 'merchant_account', 'd1fa5b4f-291c-4349-87d6-f2747ade7e32', 1, 1518435809, 1518435810, 1),
    (11471, 'merchant_account', 'f3a48acc-3529-4e6d-9a6d-1c47ff0d5d75', 2, 1518435810, 1518435811, 1);

INSERT INTO `groups` (`id`, `name`, `description`, `founder_id`, `photo_id`, `account_id`, `primary_bank_account_id`, `parent_id`, `preferences`, `status`, `create_time`, `vanity_url`, `vanity_url_normalized`, `data`, `app_id`, `theme_id`, `gaq_domains`, `settings`, `financial_admin_id`, `reference_id`, `kyc_id`, `modify_time`, `version`, `expire_time`, `disablement_time`, `country`)
VALUES
    (1, 'Merchant Kangaroo US 21550671572.account.US', 'Merchant Kangaroo US 21550671572.account.US', 145612538, 0, 32, NULL, NULL, 'a:0:{}', 33, 1550671572, NULL, NULL, 'O:8:\"stdClass\":1:{s:16:\"invitation_count\";N;}', 24646, 0, 'N;', 159, 145612538, NULL, 195374, 1550671572, 4, NULL, NULL, 'US'),
    (2, 'CA business', 'CA business', 46776263, 0, 36, NULL, NULL, 'a:2:{s:5:\"email\";a:0:{}s:11:\"permissions\";a:2:{s:6:\"public\";a:4:{s:6:\"donate\";b:0;s:4:\"join\";b:0;s:17:\"requestInvitation\";b:1;s:4:\"view\";b:1;}s:8:\"nonAdmin\";a:7:{s:11:\"contactInfo\";b:1;s:7:\"history\";b:1;s:14:\"memberActivity\";b:1;s:7:\"members\";b:1;s:8:\"requests\";b:1;s:6:\"invite\";b:0;s:11:\"viewBalance\";b:1;}}}', 4354, 1520351638, NULL, NULL, 'O:8:\"stdClass\":1:{s:16:\"invitation_count\";N;}', 183324, 0, 'N;', 159, 46776263, NULL, 36792, 1530886517, 8, NULL, NULL, 'CA');
