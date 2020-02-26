-- fin11 data for july
Select * from
`micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_service_charge` AS fin11
inner join
(SELECT reportRowId as reportHeaderIdCopy
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_service_charge`,
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header`
WHERE
  reportHeaderId = id
  AND EXTRACT(month FROM reportDateFrom) = 7
  AND EXTRACT(month FROM reportDateTo) = 7) AS row
on fin11.reportRowId = row.reportHeaderIdCopy
-- end of fin11
-- act72
Select * from
`micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail` AS ai
inner join
(SELECT reportRowId as reportHeaderIdCopy
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail`,
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header`
WHERE
  reportHeaderId = id
  AND EXTRACT(month FROM reportDateFrom) = 7
  AND EXTRACT(month FROM reportDateTo) = 7) AS row
on ai.reportRowId = row.reportHeaderIdCopy

Select * from
`micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_detail` AS af
inner join
(SELECT reportRowId as reportHeaderIdCopy
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_detail`,
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header`
WHERE
  reportHeaderId = id
  AND EXTRACT(month FROM reportDateFrom) = 7
  AND EXTRACT(month FROM reportDateTo) = 7) AS row
on af.reportRowId = row.reportHeaderIdCopy
-- end of act72

-- chase_dfr_header
SELECT * FROM `micro-bus-121218.queuing_kafka_stingray.chase_dfr_header`
where extract(month from reportDateFrom) = 7
-- end of chase_dfr_header

-- Get freshbooks order
SELECT
  SUBSTR(merchantOrderNumber, 2, 9)
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail`,
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header`
WHERE
  reportHeaderId = id
  AND EXTRACT(month FROM reportDateFrom) = 7
  AND EXTRACT(month FROM reportDateTo) = 7
  AND entityNumber = 354062
  Group by merchantOrderNumber
  Order by merchantOrderNumber

SELECT * FROM [micro-bus-121218.monolith_wepay__views_clean.payments]
where id in
(490779008,490104896,490106647,490035224,490092905,490334021,490250466,489939616,490262666,490437428,490595113,490571730,490368363,490526969,490810999,490634420,490649384,490793777,490678156,490683509,490650552,490683768,490083407,490043351,490140315,490420685,490433125,490402615,490313230,490309602,490416881,490534353,490588474,490563876,490529431,490534060,490499052,490589619,490106818,490723977,490805801,490703423,490704063,490770328,490702363,490160981,490140349,490402864,490546873,490593556,490580012,490546249,490781565,490710212,490701495,490809531,490757743,490759798,490811236)

-- get group id
SELECT recipient_account_id FROM [micro-bus-121218.monolith_wepay__views_clean.payments]
where id in
    (490779008,490104896,490106647,490035224,490092905,490334021,490250466,489939616,490262666,490437428,490595113,490571730,490368363,490526969,490810999,490634420,490649384,490793777,490678156,490683509,490650552,490683768,490083407,490043351,490140315,490420685,490433125,490402615,490313230,490309602,490416881,490534353,490588474,490563876,490529431,490534060,490499052,490589619,490106818,490723977,490805801,490703423,490704063,490770328,490702363,490160981,490140349,490402864,490546873,490593556,490580012,490546249,490781565,490710212,490701495,490809531,490757743,490759798,490811236)
group by recipient_account_id

-- prepare groups table for freshbookds
SELECT * FROM [micro-bus-121218:monolith_wepay__views_clean.groups] where account_id in
(959750853,959765931,959129913,959561720,959325433,959042784,960151582,960035495,959716845,959251895,959287328,
959187802,960346020,959294664,959039545,959712656,959322038,959993195,959491656,959260106,960010836,959439371,
960079166,959097462,959708766,960001724,959442233,959555112,959611996,959049185,960327187,959860260,960059446,
959643235,959670099,959956511,959999336,958995841,959485021,959496657,959274142,959506555,959871285,945026724,
196828301,769192407,162022187,611734718)

-- insert into fee_schedule_history
INSERT INTO `mythic-crane-708.s_lanai.entity_fee_schedule_mapping_history` ( id ,  ts_create_time ,  ts_modify_time ,  entity_id ,  currency ,  entity_type ,  fee_schedule_id ,  fee_schedule_type ,  lower_threshold ,  upper_threshold ,  operation )
VALUES
	(3, '2019-08-13 20:21:29', '2019-08-13 20:21:29', 'abc-123', 'USD', 'V2_GROUP', 7, 'CC_IC', 0, 2147483647, 'ENABLE');


-- get ACT72 info for Freshbooks July, get rid of 490779008, which is refund
SELECT * from `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail`
WHERE reportRowId in
(SELECT
  reportRowId
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail`,
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header`
WHERE
  reportHeaderId = id
  AND EXTRACT(month FROM reportDateFrom) = 7
  AND EXTRACT(month FROM reportDateTo) = 7
  AND entityNumber = 354062)
-- act72 fee detail, get rid of 490779008, which is refund
SELECT
reportHeaderId, recordType, transactionDate, entityNumber, merchantOrderNumber, feeDescription, category, subCategory, interchangeQualificationCode, interchangeQualificationDesc, frontendDowngradeReasonCode, frontendDowngradeReasonDesc, unitFee, faceValueRateFee, totalFee, currency, reportRowId, informationReportRowId

from `micro-bus-121218.queuing_kafka_stingray.chase_dfr_transaction_fee_detail`
WHERE reportRowId in
(SELECT
  reportRowId
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_detail`,
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header`
WHERE
  reportHeaderId = id
  AND EXTRACT(month FROM reportDateFrom) = 7
  AND EXTRACT(month FROM reportDateTo) = 7
  AND entityNumber = 354062)

-- insert into entity_fee_schedule_mapping_history
  INSERT INTO `mythic-crane-708.s_lanai.entity_fee_schedule_mapping_history`
(id, ts_create_time, ts_modify_time, entity_id, currency, entity_type, fee_schedule_id, fee_schedule_type, lower_threshold, upper_threshold, operation)
VALUES
   (6,'2019-07-13 20:17:26','2019-07-13 20:17:26','453390329','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (7,'2019-07-13 20:21:29','2019-07-13 20:21:29','814189988','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (8,'2019-07-13 20:21:29','2019-07-13 20:21:29','906841524','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (9,'2019-07-13 20:25:53','2019-07-13 20:25:53','800796519','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (10,'2019-07-13 20:25:53','2019-07-13 20:25:53','1729056104','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (11,'2019-07-13 20:29:19','2019-07-13 20:29:19','1916773689','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (12,'2019-07-13 20:29:19','2019-07-13 20:29:19','1235699622','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (13,'2019-07-13 20:36:03','2019-07-13 20:36:03','902007175','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (14,'2019-07-13 20:36:04','2019-07-13 20:36:04','1966247791','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (15,'2019-07-13 21:07:28','2019-07-13 21:07:28','1559928196','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (16,'2019-07-13 21:07:28','2019-07-13 21:07:28','189137422','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (17,'2019-07-13 21:09:12','2019-07-13 21:09:12','1424947723','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (18,'2019-07-13 21:09:12','2019-07-13 21:09:12','410263035','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (19,'2019-07-13 21:15:44','2019-07-13 21:15:44','929945699','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (20,'2019-07-13 21:15:44','2019-07-13 21:15:44','455961186','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (21,'2019-07-13 23:09:55','2019-07-13 23:09:55','766154123','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (22,'2019-07-13 23:09:55','2019-07-13 23:09:55','114870758','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (23,'2019-07-13 23:16:02','2019-07-13 23:16:02','1801437101','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (24,'2019-07-13 23:16:03','2019-07-13 23:16:03','1230621045','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (25,'2019-07-13 23:57:10','2019-07-13 23:57:10','1951355942','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (26,'2019-07-13 23:57:11','2019-07-13 23:57:11','1905745666','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (27,'2019-07-14 00:25:56','2019-07-14 00:25:56','205951027','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (28,'2019-07-14 00:25:56','2019-07-14 00:25:56','281864850','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (29,'2019-07-14 00:25:57','2019-07-14 00:25:57','1112049559','GBP','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (30,'2019-07-14 00:25:58','2019-07-14 00:25:58','1485024463','GBP','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (31,'2019-07-14 21:00:16','2019-07-14 21:00:16','501975241','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (32,'2019-07-14 21:00:16','2019-07-14 21:00:16','778997170','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (33,'2019-07-14 21:14:45','2019-07-14 21:14:45','14731017','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (34,'2019-07-14 21:14:45','2019-07-14 21:14:45','1785903757','USD','V2_GROUP',7,'CC_IC',1,2147483647,'ENABLE'),
   (35,'2019-07-14 21:31:24','2019-07-14 21:31:24','544889733','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (36,'2019-07-14 21:31:25','2019-07-14 21:31:25','1216821072','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (37,'2019-07-14 21:31:25','2019-07-14 21:31:25','1735755887','GBP','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (38,'2019-07-14 21:31:26','2019-07-14 21:31:26','1753594267','GBP','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (39,'2019-07-14 22:51:16','2019-07-14 22:51:16','148105075','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (40,'2019-07-14 22:51:18','2019-07-14 22:51:18','1002917502','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (41,'2019-07-14 22:51:20','2019-07-14 22:51:20','396986118','GBP','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (42,'2019-07-14 22:51:21','2019-07-14 22:51:21','1989982251','GBP','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (43,'2019-07-15 18:57:18','2019-07-15 18:57:18','1181001629','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (44,'2019-07-15 18:57:18','2019-07-15 18:57:18','445400920','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (45,'2019-07-15 21:49:40','2019-07-15 21:49:40','1710613397','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (46,'2019-07-15 21:49:40','2019-07-15 21:49:40','189194528','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (47,'2019-07-15 21:59:02','2019-07-15 21:59:02','919103560','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (48,'2019-07-15 21:59:02','2019-07-15 21:59:02','959187802','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (49,'2019-07-15 22:02:58','2019-07-15 22:02:58','b4d5878b-f01b-4e8f-bdeb-6de25e5739e4','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (50,'2019-07-15 22:02:58','2019-07-15 22:02:58','b4d5878b-f01b-4e8f-bdeb-6de25e5739e4','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (51,'2019-07-15 22:05:06','2019-07-15 22:05:06','f10ebf8c-6a1a-4295-b95a-69e4e3770d04','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (52,'2019-07-15 22:05:06','2019-07-15 22:05:06','f10ebf8c-6a1a-4295-b95a-69e4e3770d04','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (53,'2019-07-15 22:22:21','2019-07-15 22:22:21','ce62b28a-b465-4996-b24b-de2006d43198','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (54,'2019-07-15 22:22:21','2019-07-15 22:22:21','ce62b28a-b465-4996-b24b-de2006d43198','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (55,'2019-07-15 22:23:07','2019-07-15 22:23:07','e2192976-779c-4a52-a362-8797340aeb36','CAD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE'),
   (48,'2019-07-15 21:59:02','2019-07-15 21:59:02','114870758','USD','V2_GROUP',7,'CC_IC',0,2147483647,'ENABLE')

-- insert into fee_schedule table
INSERT INTO `mythic-crane-708.s_lanai.fee_schedule` (`id`, `ts_create_time`, `ts_modify_time`, `max_fee_amount`, `min_fee_amount`, `fixed_fee_amount`, `basis_point`)
VALUES
	(7, '2019-08-22 00:02:07', '2019-08-22 00:02:47', 0, 0, 20, 60);

-- update fee_schedule_id to 1251
update `mythic-crane-708.s_lanai.payments`
set fee_schedule_id = 1251
where type = 1 or type = 4
-- update fee_schedule_history time

-- get all freshbooks payment in july not including refund
"489939616","490035224","490043351","490083407","490092905","490104896","490106647","490106818","490140315","490140349","490160981","490250466","490262666","490309602","490313230","490334021","490368363","490402615","490402864","490416881","490420685","490433125","490437428","490499052","490526969","490529431","490534060","490534353","490546249","490546873","490563876","490571730","490580012","490588474","490589619","490593556","490595113","490634420","490649384","490650552","490678156","490683509","490683768","490701495","490702363","490703423","490704063","490710212","490723977","490757743","490759798","490770328","490781565"
490779008 -- refund
-- all payments
489939616,490035224,490043351,490083407,490092905,490104896,490106647,490106818,490140315,490140349,490160981,490250466,490262666,490309602,490313230,490334021,490368363,490402615,490402864,490416881,490420685,490433125,490437428,490499052,490526969,490529431,490534060,490534353,490546249,490546873,490563876,490571730,490580012,490588474,490589619,490593556,490595113,490634420,490649384,490650552,490678156,490683509,490683768,490701495,490702363,490703423,490704063,490710212,490723977,490757743,490759798,490770328,490781565, 490779008


SELECT
ai.merchantOrderNumber
FROM
  `mythic-crane-708.s_lanai.payments` AS p
INNER JOIN
  `mythic-crane-708.s_lanai.chase_dfr_transaction_fee_information_detail` AS ai
ON
  TRIM(ai.merchantOrderNumber, "\"") = CAST(p.id AS STRING)
LEFT JOIN (
  SELECT
    *
  FROM
    `mythic-crane-708.s_lanai.chase_dfr_transaction_fee_detail`
  WHERE
    category = 'IA'
    AND ( subCategory = 'IC'
      OR subCategory = 'AS')) AS af
ON
  ai.reportRowId = af.informationReportRowId
INNER JOIN
  `mythic-crane-708.s_lanai.groups` AS g
ON
  g.account_id = p.recipient_account_id
INNER JOIN
  `mythic-crane-708.s_lanai.entity_fee_schedule_mapping_history` AS efs
ON
  efs.entity_id = CAST(g.id AS STRING)
  AND efs.currency = ai.settlementCurrency
INNER JOIN (
  SELECT
    MAX(ts_create_time) AS max,
    entity_id
  FROM
    `mythic-crane-708.s_lanai.entity_fee_schedule_mapping_history`
  WHERE
    UNIX_SECONDS(ts_create_time) <= 1564617600
    AND operation = 'ENABLE'
  GROUP BY
    entity_id) temp
ON
  efs.ts_create_time = temp.max
  AND efs.entity_id = temp.entity_id
INNER JOIN
  `mythic-crane-708.s_lanai.fee_schedule` AS fs
ON
  efs.fee_schedule_id = fs.id
WHERE
p.fee_schedule_id = 1251
  AND efs.entity_type = 'V2_GROUP'
  AND efs.fee_schedule_type = 'CC_IC'
  AND p.create_time >= 1561939200
  AND p.create_time < 1564617600
  Group by merchantOrderNumber
  order by merchantOrderNumber
-- get all payments in july from act72 info not including refund
FROM `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail`
where merchantOrderNumber in (489939616,490035224,490043351,490083407,490092905,490104896,490106647,490106818,490140315,490140349,490160981,490250466,490262666,490309602,490313230,490334021,490368363,490402615,490402864,490416881,490420685,490433125,490437428,490499052,490526969,490529431,490534060,490534353,490546249,490546873,490563876,490571730,490580012,490588474,490589619,490593556,490595113,490634420,490649384,490650552,490678156,490683509,490683768,490701495,490702363,490703423,490704063,490710212,490723977,490757743,490759798,490770328,490781565)
-- get calculation result from ic_plus_fee_by_merchant
SELECT
account_id,
amount * 0.01 as amount,
interchange_fee * 0.000001 as interchange_fee,
assessment_fee * 0.000001 as assessment_fee,
markup_fee * 0.000001 as markup_fee,
extra_monthly_fee * 0.01 as extra_monthly_fee,
currency,
total_fee
FROM `mythic-crane-708.s_lanai.ic_plus_fees_by_merchant` LIMIT 1000

--Get all payment id in report from June, July and < Aug 5th
SELECT
 TRIM(ai.merchantOrderNumber, '/')
FROM
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_transaction_fee_information_detail` ai
INNER JOIN
  `micro-bus-121218.queuing_kafka_stingray__clean_rt.chase_dfr_header` h
ON
  ai.reportHeaderId = h.id
WHERE
  (EXTRACT(month
    FROM
      reportDateFrom) = 7
    OR (EXTRACT(month
      FROM
        reportDateFrom) = 8
      AND EXTRACT(Day
      FROM
        reportDateFrom) < 5)
    OR EXTRACT(month
    FROM
      reportDateFrom) = 6)
  AND ai.entityNumber = 354062

-- add to refunds
SELECT * FROM [micro-bus-121218:monolith_wepay__views_clean.refunds]
where rpr_id = 653508878 OR payment_request_id = 653508878

-- add to payment_requests
SELECT * FROM [micro-bus-121218:monolith_wepay__views_clean.payment_requests]
where id in (  653508878, 652792827)

-- for ach payments
SELECT * FROM [micro-bus-121218:monolith_wepay__views_clean.payments]
where id in
(499827195,
499813616,
499810940,
499803583,
499801238)

update  `mythic-crane-708.mingm.payments`
set fee_schedule_id = 1251
where id in
(499827195,
499813616,
499810940,
499803583,
499801238)

update  `mythic-crane-708.mingm.payments`
set create_time = 1565913600
where id in
(499827195,
499813616,
499810940,
499803583,
499801238,
494223723)

-- ach groups

SELECT * FROM [micro-bus-121218:monolith_wepay__views_clean.groups]
where account_id in
(162022187,
196828301,
945026724,
611734718,
769192407,
784385554)
Row	group_id	account_id
1	1960030732	945026724
2	907261842	196828301
3	1834826206	769192407
4	1754693044	162022187
5	1520075266	611734718
6    391371500  784385554
-- ach entity_fee_schedule_mapping_history
  INSERT INTO `mythic-crane-708.mingm.entity_fee_schedule_mapping_history`
(id, ts_create_time, ts_modify_time, entity_id, currency, entity_type, fee_schedule_id, fee_schedule_type, lower_threshold, upper_threshold, operation)
VALUES
   (101,'2019-07-13 20:17:26','2019-07-13 20:17:26','1960030732','USD','V2_GROUP',36,'ACH_T1',0,500,'ENABLE'),
   (102,'2019-07-13 20:21:29','2019-07-13 20:21:29','1960030732','USD','V2_GROUP',36,'ACH_T2',500,5000,'ENABLE'),
   (103,'2019-07-13 20:21:29','2019-07-13 20:21:29','1960030732','USD','V2_GROUP',36,'ACH_T3',5000,50000,'ENABLE'),
   (104,'2019-07-13 20:25:53','2019-07-13 20:25:53','1960030732','USD','V2_GROUP',36,'ACH_T4',50000,2147483647,'ENABLE'),
   (105,'2019-07-13 20:17:26','2019-07-13 20:17:26','907261842','USD','V2_GROUP',36,'ACH_T1',0,2147483647,'ENABLE'),
   (106,'2019-07-13 20:21:29','2019-07-13 20:21:29','1834826206','USD','V2_GROUP',36,'ACH_T2',0,2147483647,'ENABLE'),
  (109,'2019-07-13 20:25:53','2019-07-13 20:25:53','3ea98503-1f63-46dd-b69a-fcb569cc3d45','USD','V3_MERCHANT',36,'ACH_T4',0,2147483647,'ENABLE'),
   (110,'2019-07-13 20:25:53','2019-07-13 20:25:53','5bf129e2-f74a-4538-a21b-7035e264083f','USD','V3_MERCHANT',36,'ACH_T4',0,2147483647,'ENABLE'),
    (111,'2019-07-13 20:25:53','2019-07-13 20:25:53','126f0930-75d2-4bb6-854c-f2420d7cf7a4','USD','V3_MERCHANT',36,'ACH_T1',0,5000,'ENABLE'),
    (112,'2019-07-13 20:25:53','2019-07-13 20:25:53','126f0930-75d2-4bb6-854c-f2420d7cf7a4','USD','V3_MERCHANT',36,'ACH_T2',5000,50000,'ENABLE'),
    (113,'2019-07-13 20:25:53','2019-07-13 20:25:53','126f0930-75d2-4bb6-854c-f2420d7cf7a4','USD','V3_MERCHANT',36,'ACH_T3',50000,500000,'ENABLE'),
    (114,'2019-07-13 20:25:53','2019-07-13 20:25:53','126f0930-75d2-4bb6-854c-f2420d7cf7a4','USD','V3_MERCHANT',36,'ACH_T4',500000,2147483647,'ENABLE')



-- fee schedule
INSERT INTO `mythic-crane-708.mingm.fee_schedule` (`id`, `ts_create_time`, `ts_modify_time`, `max_fee_amount`, `min_fee_amount`, `fixed_fee_amount`, `basis_point`)
VALUES
	(36, '2019-08-22 00:02:07', '2019-08-22 00:02:47', 5000, 50, 20, 60);

-- shadow_group_mapping
INSERT INTO `mythic-crane-708.mingm.shadow_group_mapping` (`id`, `mapping_object_type`, `mapping_object_id`, `group_id`, `create_time`, `modify_time`, `version`)
VALUES
	(11465, 'merchant_account', '3ea98503-1f63-46dd-b69a-fcb569cc3d45', 1754693044, 1518435793, 1518435794, 1),
	(11466, 'merchant_account', '5bf129e2-f74a-4538-a21b-7035e264083f', 1520075266, 1518435803, 1518435804, 1),
	(11467, 'merchant_account', '126f0930-75d2-4bb6-854c-f2420d7cf7a4',  391371500, 1518435803, 1518435804, 1);

--aevi_transaction
INSERT INTO `mythic-crane-708.lanai_test.aevi_transaction` (`id`, `transaction_id`, `payment_id`)
values
(1, '02f3d3ac-34be-4971-99f1-be0bbbbd7bb6', 501330957),
(1, '4FE58679-110A-42FE-9D04-95FC5C786687', 502655362),
(1, 'F0DF154D-F97A-4906-8914-3842C35F8433', 502659493);