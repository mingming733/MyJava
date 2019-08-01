import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StringProc {

    String target = "add(ServiceCategory.INTERNET,\n" +
            "                pair(OFOF, 1048483937L),\n" +
            "                pair(NFOF, 2044302172L),\n" +
            "                pair(CA_AMEX, 9323790676L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542462940L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840861L));\n" +
            "        add(ServiceCategory.RETAIL,\n" +
            "                pair(OFOF, 2046219887L),\n" +
            "                pair(NFOF, 2044933141L),\n" +
            "                pair(CA_AMEX, 9323770538L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457627L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840796L));\n" +
            "        add(ServiceCategory.HEALTHCARE,\n" +
            "                pair(OFOF, 2046219945L),\n" +
            "                pair(NFOF, 2044933216L),\n" +
            "                pair(CA_AMEX, 9323790684L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457692L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840838L));\n" +
            "        add(ServiceCategory.SERVICES,\n" +
            "                pair(OFOF, 2046219978L),\n" +
            "                pair(NFOF, 2044933166L),\n" +
            "                pair(CA_AMEX, 9323790650L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457668L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840812L));\n" +
            "        add(ServiceCategory.HEALTHCARE_PRACTITONER,\n" +
            "                pair(OFOF, 2046219994L),\n" +
            "                pair(NFOF, 2044933224L),\n" +
            "                pair(CA_AMEX, 9323790692L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457692L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840838L));\n" +
            "        add(ServiceCategory.RESTAURANT,\n" +
            "                pair(OFOF, 2046220018L),\n" +
            "                pair(NFOF, 2044933133L),\n" +
            "                pair(CA_AMEX, 9323790668L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457643L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840770L));\n" +
            "        add(ServiceCategory.B2B_WHOLESALE,\n" +
            "                pair(OFOF, 2046220042L),\n" +
            "                pair(NFOF, 2044933158L),\n" +
            "                pair(CA_AMEX, 9323790700L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457700L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840804L));\n" +
            "        add(ServiceCategory.CATER_DRINK,\n" +
            "                pair(OFOF, 2046220059L),\n" +
            "                pair(NFOF, 2044933265L),\n" +
            "                pair(CA_AMEX, 9323790668L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457676L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840788L));\n" +
            "        add(ServiceCategory.OTHER,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542460035L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840853L));\n" +
            "        add(ServiceCategory.PROHIBITED,\n" +
            "                pair(OFOF, 2046220521L),\n" +
            "                pair(NFOF, 2044933232L),\n" +
            "                pair(CA_AMEX, 9323790718L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542460035L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840853L));\n" +
            "        add(ServiceCategory.GOVERNMENT,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 1546508698L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 1548293893L));\n" +
            "        add(ServiceCategory.EDUCATION,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 1546508706L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 1548293885L));";
    public void process() {
        StringBuilder result = new StringBuilder();
        String[] strings = target.split("[^\\w']+");
        int n = strings.length;
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].equals("ServiceCategory")) {
                result.append(strings[i + 1]).append(" ");
            } else if (strings[i].equals("LITLE_AMEX_OPTBLUE")) {
                result.append(strings[i + 1]).append("\n");
            }
        }
        System.out.println(result.toString());
    }

    public void getMapping() {
        String mccs = "0\t1520\t1711\t1731\t1740\t1750\t1761\t1771\t1799\t2741\t2791\t2842\t4011\t4111\t4112\t4119\t4121\t4131\t4214\t4215\t4225\t4411\t4457\t4468\t4511\t4582\t4784\t4789\t4812\t4814\t4815\t4816\t4821\t4829\t4899\t4900\t5013\t5021\t5039\t5044\t5045\t5046\t5047\t5051\t5065\t5072\t5074\t5085\t5094\t5099\t5111\t5122\t5131\t5137\t5139\t5169\t5172\t5192\t5193\t5198\t5199\t5200\t5211\t5231\t5251\t5261\t5271\t5300\t5309\t5310\t5311\t5331\t5399\t5411\t5422\t5441\t5451\t5462\t5499\t5511\t5521\t5531\t5532\t5533\t5541\t5542\t5551\t5561\t5571\t5592\t5598\t5599\t5611\t5621\t5631\t5641\t5651\t5655\t5661\t5681\t5691\t5697\t5698\t5699\t5712\t5713\t5714\t5715\t5718\t5719\t5722\t5732\t5733\t5734\t5735\t5811\t5812\t5813\t5814\t5912\t5921\t5931\t5932\t5933\t5935\t5937\t5940\t5941\t5942\t5943\t5944\t5945\t5946\t5947\t5948\t5949\t5950\t5960\t5962\t5963\t5964\t5965\t5966\t5967\t5968\t5969\t5970\t5971\t5972\t5973\t5975\t5976\t5977\t5978\t5983\t5992\t5993\t5994\t5995\t5996\t5997\t5998\t5999\t6010\t6011\t6012\t6051\t6211\t6300\t7012\t7032\t7210\t7211\t7216\t7217\t7221\t7230\t7251\t7261\t7273\t7276\t7277\t7278\t7296\t7297\t7298\t7299\t7311\t7321\t7322\t7333\t7338\t7339\t7342\t7349\t7361\t7372\t7375\t7379\t7392\t7393\t7394\t7395\t7399\t(742\t(743\t(744\t7512\t7513\t7519\t7523\t7531\t7534\t7535\t7538\t7542\t7549\t7622\t7623\t7629\t(763\t7631\t7641\t7692\t7699\t(780\t7829\t7832\t7841\t7911\t7922\t7929\t7932\t7933\t7941\t7991\t7992\t7993\t7994\t7997\t7998\t8011\t8021\t8031\t8041\t8042\t8043\t8049\t8050\t8062\t8071\t8099\t8111\t8211\t8220\t8241\t8244\t8249\t8299\t8351\t8398\t8641\t8651\t8661\t8675\t8699\t8734\t8911\t8931\t8999\t9211\t9222\t9223\t9311\t9399\t9402\tdd(0\t1520\t1711\t1731\t1740\t1750\t1761\t1771\t1799\t2741\t2791\t2842\t4011\t4111\t4112\t4119\t4121\t4131\t4214\t4215\t4225\t4411\t4457\t4468\t4511\t4582\t4784\t4789\t4812\t4814\t4815\t4816\t4821\t4829\t4899\t4900\t5013\t5021\t5039\t5044\t5045\t5046\t5047\t5051\t5065\t5072\t5074\t5085\t5094\t5099\t5111\t5122\t5131\t5137\t5139\t5169\t5172\t5192\t5193\t5198\t5199\t5200\t5211\t5231\t5251\t5261\t5271\t5300\t5309\t5310\t5311\t5331\t5399\t5411\t5422\t5441\t5451\t5462\t5499\t5511\t5521\t5531\t5532\t5533\t5541\t5542\t5551\t5561\t5571\t5592\t5598\t5599\t5611\t5621\t5631\t5641\t5651\t5655\t5661\t5681\t5691\t5697\t5698\t5699\t5712\t5713\t5714\t5715\t5718\t5719\t5722\t5732\t5733\t5734\t5735\t5811\t5812\t5813\t5814\t5912\t5921\t5931\t5932\t5933\t5935\t5937\t5940\t5941\t5942\t5943\t5944\t5945\t5946\t5947\t5948\t5949\t5950\t5960\t5962\t5963\t5964\t5965\t5966\t5967\t5968\t5969\t5970\t5971\t5972\t5973\t5975\t5976\t5977\t5978\t5983\t5992\t5993\t5994\t5995\t5996\t5997\t5998\t5999\t6010\t6011\t6012\t6051\t6211\t6300\t7012\t7032\t7210\t7211\t7216\t7217\t7221\t7230\t7251\t7261\t7273\t7276\t7277\t7278\t7296\t7297\t7298\t7299\t7311\t7321\t7322\t7333\t7338\t7339\t7342\t7349\t7361\t7372\t7375\t7379\t7392\t7393\t7394\t7395\t7399\t(742\t(743\t(744\t7512\t7513\t7519\t7523\t7531\t7534\t7535\t7538\t7542\t7549\t7622\t7623\t7629\t(763\t7631\t7641\t7692\t7699\t(780\t7829\t7832\t7841\t7911\t7922\t7929\t7932\t7933\t7941\t7991\t7992\t7993\t7994\t7997\t7998\t8011\t8021\t8031\t8041\t8042\t8043\t8049\t8050\t8062\t8071\t8099\t8111\t8211\t8220\t8241\t8244\t8249\t8299\t8351\t8398\t8641\t8651\t8661\t8675\t8699\t8734\t8911\t8931\t8999\t9211\t9222\t9223\t9311\t9399\t9402";
        String[] pairsArr = pairs.split("\n");
        Map<String, String> maps = new HashMap<>();
        for (String str : pairsArr) {
            String[] pair = str.split(",");
            maps.put(pair[0], pair[1]);
        }
        String[] mccStr = mccs.split("\t");
        for (String mcc: mccStr) {
            System.out.println(maps.get(mcc));
        }
    }
    public void dedup() {
        Set<String> set = new HashSet<>();
        String[] strings = target2.split("\n");
        for (String str : strings) {
            set.add(str);
        }
        StringBuilder result = new StringBuilder();
        for (Object str : set.toArray()) {
            result.append(str.toString()).append(" \n");
        }
        System.out.println(result);
    }

    public void intersection() {
        String[] codeStrs = codeCate.split("\n");
        Set<String> set = new HashSet<>();
        for (String str: codeStrs) {
            set.add(str);
        }
        String[] excelStrs = excelCate.split("\n");

        Map<String, String> map = new HashMap<>();
        for (String str : codeStrs) {
            if (!map.containsKey(str.substring(0,4))) {
                map.put(str.substring(0,4), str);
            }
        }
        for (String str : excelStrs) {
            if (map.containsKey(str.substring(0,4))) {
                System.out.print(str + "\n");
                System.out.println(map.get(str.substring(0,4)) + "\n");
            }
        }
        System.out.println("done");
    }
    String target2 = "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_RETAIL9323770538\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "PROHIBITED9323790718\n" +
            "SE_RETAIL9323770538\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_CATER_DRINK9323790668\n" +
            "SE_RESTAURANT9323790668\n" +
            "SE_CATER_DRINK9323790668\n" +
            "SE_RESTAURANT9323790668\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_INTERNET9323790676\n" +
            "SE_RETAIL9323770538\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_INTERNET9323790676\n" +
            "SE_INTERNET9323790676\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "SE_RETAIL9323770538\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "PROHIBITED9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "PROHIBITED9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_RETAIL9323770538\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_HEALTHCARE_PRACTITONER9323790692\n" +
            "SE_HEALTHCARE_PRACTITONER9323790692\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_HEALTHCARE9323790684\n" +
            "SE_SERVICES9323790650\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_OTHER9323790718\n" +
            "SE_SERVICES9323790650\n" +
            "SE_SERVICES9323790650\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_B2B_WHOLESALE9323790700\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "PROHIBITED9323790718\n" +
            "SE_OTHER9323790718\n" +
            "SE_OTHER9323790718\n" +
            "PROHIBITED9323790718";
    String excelCate =
            "1520\tGENERAL CONTRACTOR \tServices and Professional Services\n" +
            "1711\tHEATING PLUMBING AC \tServices and Professional Services\n" +
            "1731\tELECTRICAL CONTRACTOR \tServices and Professional Services\n" +
            "1740\tMASONRY TILE INSULATE \tServices and Professional Services\n" +
            "1750\tCARPENTRY CONTRACTOR \tServices and Professional Services\n" +
            "1761\tROOFING SIDING \tServices and Professional Services\n" +
            "1771\tCONCRETE WORK \tServices and Professional Services\n" +
            "1799\tMISC CONTRACTOR \tB2B/Wholesale\n" +
            "2741\tPUBLISHING PRINTING \tServices and Professional Services\n" +
            "2791\tTYPESETTING SERVICE \tB2B/Wholesale\n" +
            "2842\tMISC CLEANING PRODUCT \tServices and Professional Services\n" +
            "4111\t\"Local and Suburban Commuter Passenger\n" +
            "Transportation\"\tT&E\n" +
            "4112\tPassenger Railways\tT&E\n" +
            "4119\tAMBULANCE SERVICE \tHealthcare\n" +
            "4121\tTAXICAB LIMOUSINE \tT&E\n" +
            "4131\tBUS LINE \tT&E\n" +
            "4214\tFREIGHT MOVING \tServices and Professional Services\n" +
            "4011\tRailroads - Freight\tB2B/Wholesale\n" +
            "4215\tCOURIER SERVICE \tB2B/Wholesale\n" +
            "4225\tWAREHOUSING \tServices and Professional Services\n" +
            "4457\tBOAT RENTAL \tServices and Professional Services\n" +
            "4468\tMARINE SERVICE SUPPLY \tServices and Professional Services\n" +
            "4582\tAIRPORT TERMINAL \tT&E\n" +
            "4722\tTRAVEL AGENCY* \tT&E\n" +
            "4784\tTOLL BRIDGE FEE \tGovernment\n" +
            "4789\tMISC TRANSPORTATION \tT&E\n" +
            "4812\tTELECOM EQUIPMENT \tOther\n" +
            "4816\tCOMPUTER NETWORK \tServices and Professional Services\n" +
            "4821\tTELEGRAPH SERVICE \tServices and Professional Services\n" +
            "4899\tCABLE PAY TV \tOther\n" +
            "4900\tPUBLIC UTILITY \tServices and Professional Services\n" +
            "5013\tAUTO SUPPLIES PARTS \tRetail\n" +
            "5021\tOFFICE FURNITURE \tRetail\n" +
            "5039\tCONSTRUCTION MATERIAL \tB2B/Wholesale\n" +
            "5044\tOFFICE EQUIPMENT \tRetail\n" +
            "5045\tCOMPUTERS EQUIPMENT \tB2B/Wholesale\n" +
            "5046\tCOMMERICAL EQUIPMENT \tB2B/Wholesale\n" +
            "5047\tMEDICAL EQUIPMENT \tB2B/Wholesale\n" +
            "5051\tMETAL SERVICE CENTER \tB2B/Wholesale\n" +
            "5065\tELECTRICAL EQUIPMENT \tB2B/Wholesale\n" +
            "5072\tHARDWARE EQUIPMENT \tRetail\n" +
            "5074\tPLUMBING HEATING \tServices and Professional Services\n" +
            "5085\tINDUSTRIAL SUPPLY \tB2B/Wholesale\n" +
            "5094\tJEWELRY WATCHES \tB2B/Wholesale\n" +
            "5099\tDURABLE GOODS \tB2B/Wholesale\n" +
            "5111\tOFFICE SUPPLIES \tB2B/Wholesale\n" +
            "5122\tDRUGS \tRetail\n" +
            "5131\tFABRICS \tB2B/Wholesale\n" +
            "5137\tCOMMERCIAL CLOTHING \tB2B/Wholesale\n" +
            "5139\tCOMMERCIAL FOOTWEAR \tB2B/Wholesale\n" +
            "5169\tCHEMICALS \tB2B/Wholesale\n" +
            "5192\tBOOKS NEWSPAPERS \tRetail\n" +
            "5172\tPetroleum & Petroleum Products - Wholesale Distributors\tB2B/Wholesale\n" +
            "5193\tFLORISTS' SUPPLIES \tRetail\n" +
            "5198\tPAINTS VARNISHES \tB2B/Wholesale\n" +
            "5199\tNON-DURABLE GOODS \tB2B/Wholesale\n" +
            "5200\tHOME SUPPLY WAREHOUSE \tRetail\n" +
            "5211\tLUMBER BUILDING \tRetail\n" +
            "5231\tGLASS PAINT WALLPAPER \tRetail\n" +
            "5251\tHARDWARE STORE \tRetail\n" +
            "5261\tLAWN GARDEN SUPPLIES \tRetail\n" +
            "5271\tMOBILE HOME DEALER \tServices and Professional Services\n" +
            "5300\tWHOLESALE CLUB \tRetail\n" +
            "5309\tDUTY-FREE STORE \tRetail\n" +
            "5310\tDISCOUNT STORE \tRetail\n" +
            "5311\tDEPARTMENT STORE \tRetail\n" +
            "5331\tVARIETY STORE \tRetail\n" +
            "5399\tGENERAL MERCHANDISE \tRetail\n" +
            "5411\tGROCERY STORE \tRetail\n" +
            "5422\tFREEZER LOCKER MEAT \tRetail\n" +
            "5441\tCANDY CONFECTIONERY \tRetail\n" +
            "5451\tDAIRY PRODUCTS STORE \tRetail\n" +
            "5462\tBAKERY \tRetail\n" +
            "5499\tMISC FOOD STORE \tRetail\n" +
            "5511\tAUTO DEALER NEW USED \tServices and Professional Services\n" +
            "5521\tAUTO DEALER USED \tServices and Professional Services\n" +
            "5531\tAUTO HOME SUPPLY \tRetail\n" +
            "5532\tAUTOMOTIVE TIRE \tRetail\n" +
            "5533\tAUTO PARTS ACCESSORY \tRetail\n" +
            "5541\tGAS STATION \tOther\n" +
            "5542\tAUTO FUEL DISPENSER \tOther\n" +
            "5551\tBOAT DEALER \tRetail\n" +
            "5561\tCAMPER TRAILER DEALER \tServices and Professional Services\n" +
            "5571\tMOTORCYCLE DEALER \tServices and Professional Services\n" +
            "5592\tMOTOR HOME DEALER \tServices and Professional Services\n" +
            "5598\tSNOWMOBILE DEALER \tServices and Professional Services\n" +
            "5599\tMISC VEHICLE DEALER \tServices and Professional Services\n" +
            "5611\tMEN'S CLOTHING \tRetail\n" +
            "5621\tWOMEN'S CLOTHING \tRetail\n" +
            "5631\tWOMEN'S ACCESSORIES \tRetail\n" +
            "5641\tCHILDREN'S CLOTHING \tRetail\n" +
            "5651\tFAMILY CLOTHING \tRetail\n" +
            "5655\tSPORTS CLOTHING \tRetail\n" +
            "5661\tSHOE STORES \tRetail\n" +
            "5681\tFURRIER AND FUR SHOP \tRetail\n" +
            "5691\tMEN'S WOMEN'S CLOTHNG \tRetail\n" +
            "5697\tTAILOR SEAMSTRESS \tServices and Professional Services\n" +
            "5698\tWIG AND TOUPEE STORE \tRetail\n" +
            "5699\tMISC APPAREL STORE \tRetail\n" +
            "5712\tFURNITURE HOME STORE \tRetail\n" +
            "5713\tFLOOR COVERING STORE \tRetail\n" +
            "5714\tDRAPERY UPHOLSTERY \tRetail\n" +
            "5715\tWHOLESALE ALCOHOL \tRetail\n" +
            "5718\tFIREPLACE ACCESSORIES \tRetail\n" +
            "5719\tMISC HOME FURNISHINGS \tRetail\n" +
            "5722\tHOUSEHOLD APPLIANCES \tRetail\n" +
            "5732\tELECTRONICS STORE \tRetail\n" +
            "5733\tMUSIC STORES \tRetail\n" +
            "5734\tCOMPUTER STORES \tRetail\n" +
            "5735\tRECORD STORES \tRetail\n" +
            "5811\tCATERER \tRestaurant\n" +
            "5812\tRESTAURANT \tRestaurant\n" +
            "5813\tBAR NIGHTCLUB \tRestaurant\n" +
            "5814\tFAST FOOD RESTAURANT \tRestaurant\n" +
            "5815\tDigital Goods Media – Books, Movies, Music\tRetail\n" +
            "5816\tDigital Goods -  Games\tRetail\n" +
            "5817\tDigital Goods - Application (Excludes Games)\tRetail\n" +
            "5818\tDigital Goods - Large Digital Goods Merchants\tRetail\n" +
            "5912\tDRUG STORE PHARMACY \tRetail\n" +
            "5921\tLIQUOR STORES \tRetail\n" +
            "5931\tUSED MERCHANDISE \tRetail\n" +
            "5932\tANTIQUE SHOP \tRetail\n" +
            "5933\tPAWN SHOP \tServices and Professional Services\n" +
            "5935\tWRECKING SALVAGE \tServices and Professional Services\n" +
            "5937\tANTIQUE REPRODUCTION \tRetail\n" +
            "5940\tBICYCLE SHOP \tRetail\n" +
            "5941\tSPORTING GOODS STORE \tRetail\n" +
            "5942\tBOOK STORE \tRetail\n" +
            "5943\tOFFICE SUPPLY STORE \tRetail\n" +
            "5944\tJEWELRY WATCH SILVRWR \tRetail\n" +
            "5945\tHOBBY TOY GAME \tRetail\n" +
            "5946\tCAMERA PHOTO SUPPLY \tRetail\n" +
            "5947\tCARD SOUVENIR STORE \tRetail\n" +
            "5948\tLUGGAGE LEATHER GOODS \tRetail\n" +
            "5949\tSEWING FABRIC STORE \tRetail\n" +
            "5950\tGLASSWARE CRYSTAL \tRetail\n" +
            "5960\tDirect Maketing - Insurance Services\tEmergingMarkets\n" +
            "5964\tCATALOG MERCHANDISE \tServices and Professional Services\n" +
            "5965\tCATALOG SHOWROOM \tRetail\n" +
            "5968\tDirect Marketing – Continuity/Subscription Merchant \tEmergingMarkets\n" +
            "5969\tDIRECT MKTG MISC \tServices and Professional Services\n" +
            "5970\tARTIST SUPPLY CRAFT \tRetail\n" +
            "5971\tART DEALER GALLERY \tRetail\n" +
            "5972\tSTAMP COIN STORE \tRetail\n" +
            "5973\tRELIGIOUS GOODS \tRetail\n" +
            "5975\tHEARING AIDS \tServices and Professional Services\n" +
            "5976\tORTHOPEDIC PROSTHETIC \tServices and Professional Services\n" +
            "5977\tCOSMETIC STORE \tRetail\n" +
            "5978\tTYPEWRITER STORE \tRetail\n" +
            "5983\tFUEL DEALER \tServices and Professional Services\n" +
            "5992\tFLORIST \tRetail\n" +
            "5993\tCIGAR STORE STAND \tRetail\n" +
            "5994\tNEWS DEALER NEWSSTAND \tRetail\n" +
            "5995\tPET SHOP FOOD SUPPLY \tRetail\n" +
            "5996\tSWIMMING POOLS \tRetail\n" +
            "5997\tELECTRIC RAZOR STORE \tRetail\n" +
            "5998\tTENT AND AWNING \tRetail\n" +
            "5999\tMISC SPECIALTY RETAIL \tRetail\n" +
            "6300\tINSURANCE SALES \tEmergingMarkets\n" +
            "6513\t\"REAL ESTATE AGENTS AND\n" +
            "MANAGERS – RENTALS\"\tServices and Professional Services\n" +
            "7011\tLODGING* \tT&E\n" +
            "7032\tRECREATION CAMP \tEducation\n" +
            "7033\tCAMPGROUND \tT&E\n" +
            "7210\tCLEANING GARMENT \tServices and Professional Services\n" +
            "7211\tLAUNDRY SERVICE \tServices and Professional Services\n" +
            "7216\tDRY CLEANER \tServices and Professional Services\n" +
            "7217\tCARPET CLEANING \tServices and Professional Services\n" +
            "7221\tPHOTOGRAPHIC STUDIO \tServices and Professional Services\n" +
            "7230\tBEAUTY BARBER SHOP \tServices and Professional Services\n" +
            "7251\tSHOE REPAIR SHINE \tServices and Professional Services\n" +
            "7261\tFUNERAL SERVICE \tServices and Professional Services\n" +
            "7273\tDating Services\tServices and Professional Services\n" +
            "7276\tTAX PREPARATION \tServices and Professional Services\n" +
            "7277\tCOUNSELING SERVICE \tServices and Professional Services\n" +
            "7278\tBUYING SHOPPING CLUBS \tServices and Professional Services\n" +
            "7296\tCLOTHING RENTAL \tRetail\n" +
            "7297\tMassage Parlors\tServices and Professional Services\n" +
            "7298\tHEALTH BEAUTY SPA \tServices and Professional Services\n" +
            "7299\tMISC PERSONAL SERVICE \tServices and Professional Services\n" +
            "7311\tADVERTISING SERVICE \tB2B/Wholesale\n" +
            "7321\tCREDIT REPORTING \tServices and Professional Services\n" +
            "7333\tCOMML PHOTO ART \tB2B/Wholesale\n" +
            "7338\tCOPY REPRODUCTION \tB2B/Wholesale\n" +
            "7339\tSECRETARIAL SUPPORT \tB2B/Wholesale\n" +
            "7342\tEXTERMINATE DISINFECT \tServices and Professional Services\n" +
            "7349\tCLEANING JANITORIAL \tB2B/Wholesale\n" +
            "7361\tEMPLOYMENT AGENCY \tB2B/Wholesale\n" +
            "7372\tCOMPUTER PROGRAMMING \tServices and Professional Services\n" +
            "7375\tINFORMATION RETRIEVAL \tServices and Professional Services\n" +
            "7379\tCOMPUTER MAINTENANCE \tServices and Professional Services\n" +
            "7392\tMGMT CONSULTING PR \tB2B/Wholesale\n" +
            "7393\tSECURITY SERVICE \tServices and Professional Services\n" +
            "7394\tEQUIPMENT RENTALS \tB2B/Wholesale\n" +
            "7395\tPHOTO FINISHING \tServices and Professional Services\n" +
            "7399\tBUSINESS SERVICES \tB2B/Wholesale\n" +
            "7512\tAutomobile Rental Agency\tT&E\n" +
            "7513\tTruck and Utility Trailer Rentals\tServices and Professional Services\n" +
            "7519\tMotor Home & Recreational Vehicle Rentals\tServices and Professional Services\n" +
            "7523\tPARKING LOT GARAGE \tServices and Professional Services\n" +
            "7531\tAUTO BODY REPAIR \tServices and Professional Services\n" +
            "7534\tTIRE REPAIR \tServices and Professional Services\n" +
            "7535\tAUTO PAINT SHOP \tServices and Professional Services\n" +
            "7538\tAUTO SERVICE \tServices and Professional Services\n" +
            "7542\tCAR WASH \tServices and Professional Services\n" +
            "7549\tTOWING SERVICE \tServices and Professional Services\n" +
            "7622\tELECTRONICS REPAIR \tRetail\n" +
            "7623\tAC REFRIG REPAIR \tServices and Professional Services\n" +
            "7629\tAPPLIANCE REPAIR \tServices and Professional Services\n" +
            "7631\tWATCH JEWELRY REPAIR \tRetail\n" +
            "7641\tFURNITURE REPAIR \tServices and Professional Services\n" +
            "7692\tWELDING SERVICES \tB2B/Wholesale\n" +
            "7699\tMISC REPAIR SHOP \tServices and Professional Services\n" +
            "7829\tVIDEO PRODUCTION \tB2B/Wholesale\n" +
            "7832\tMOVIE THEATER \tT&E\n" +
            "7841\tVIDEO RENTAL STORE \tRetail\n" +
            "7911\tDANCE HALL SCHOOL \tEducation\n" +
            "7922\tTICKET AGENCY \tT&E\n" +
            "7929\tMISC ENTERTAINER \tT&E\n" +
            "7932\tBILLIARD POOL \tT&E\n" +
            "7933\tBOWLING ALLEY \tT&E\n" +
            "7941\tCOMMERCIAL SPORTS \tT&E\n" +
            "7991\tTOURIST ATTRACTION \tT&E\n" +
            "7992\tPUBLIC GOLF COURSE \tT&E\n" +
            "7993\tVIDEO GAME SUPPLY \tT&E\n" +
            "7994\tVIDEO GAME ARCADE \tT&E\n" +
            "7996\tAMUSEMENT PARK \tT&E\n" +
            "7997\tMEMBERSHIP CLUB \tServices and Professional Services\n" +
            "7998\tAQUARIUM \tT&E\n" +
            "7999\tRECREATION SERVICE \tT&E\n" +
            "8011\tDOCTOR PHYSICIAN \tHealthcare\n" +
            "8021\tDENTIST ORTHODONTIST \tHealthcare\n" +
            "8031\tOSTEOPATH \tHealthcare\n" +
            "8041\tCHIROPRACTOR \tHealthcare\n" +
            "8042\tOPTOMETRIST \tHealthcare\n" +
            "8043\tOPTICIAN \tHealthcare\n" +
            "8049\tPODIATRIST \tHealthcare\n" +
            "8050\tNURSING PERSONAL CARE \tHealthcare\n" +
            "8062\tHOSPITAL \tHealthcare\n" +
            "8071\tMEDICAL DENTAL LAB \tHealthcare\n" +
            "8099\tMEDICAL SERVICES \tHealthcare\n" +
            "8111\tLEGAL SERVICE \tServices and Professional Services\n" +
            "8211\tElementary & Secondary SCHOOL \tEmergingMarkets\n" +
            "8220\t\"Colleges, Universities, Professional Schools, and\n" +
            "Junior Colleges \"\tEmergingMarkets\n" +
            "8241\tCORRESPONDENCE SCHOOL \tEducation\n" +
            "8244\tSECRETARIAL SCHOOL \tEducation\n" +
            "8249\tTRADE VOCATION SCHOOL \tEducation\n" +
            "8299\tEDUCATIONAL SERVICE \tEducation\n" +
            "8351\tCHILD CARE SERVICES \tEmergingMarkets\n" +
            "8398\tCHARITABLE ORG \tEmergingMarkets\n" +
            "8641\tCIVIC SOCIAL ASSOC \tServices and Professional Services\n" +
            "8651\tPOLITICAL ORG \tOther\n" +
            "8661\tRELIGIOUS ORG \tOther\n" +
            "8675\tAUTOMOBILE ASSOC \tServices and Professional Services\n" +
            "8699\tMEMBERSHIP ORGS \tServices and Professional Services\n" +
            "8734\tTESTING LABORATORY \tB2B/Wholesale\n" +
            "8911\tARCHITECT ENGINEER \tB2B/Wholesale\n" +
            "8931\tACCOUNTING AUDITING \tB2B/Wholesale\n" +
            "8999\tPROFESSIONAL SERVICES \tB2B/Wholesale\n" +
            "9211\tCOURT COSTS \tEmergingMarkets\n" +
            "9222\tFINES \tEmergingMarkets\n" +
            "9223\tBail and Bond Payments (Fee Only)\tGovernment\n" +
            "9311\tTAX PAYMENTS \tGovernment\n" +
            "9399\tGOVERNMENT SERVICES \tEmergingMarkets";

    String codeCate = "0, \"UNKNOWN\", ServiceCategory.OTHER),\n" +
            "1520, \"GENERAL CONTRACTOR\", ServiceCategory.SERVICES),\n" +
            "1711, \"HEATING PLUMBING AC\", ServiceCategory.SERVICES),\n" +
            "1731, \"ELECTRICAL CONTRACTOR\", ServiceCategory.SERVICES),\n" +
            "1740, \"MASONRY TILE INSULATE\", ServiceCategory.SERVICES),\n" +
            "1750, \"CARPENTRY CONTRACTOR\", ServiceCategory.SERVICES),\n" +
            "1761, \"ROOFING SIDING\", ServiceCategory.SERVICES),\n" +
            "1771, \"CONCRETE WORK\", ServiceCategory.SERVICES),\n" +
            "1799, \"MISC CONTRACTOR\", ServiceCategory.B2B_WHOLESALE),\n" +
            "2741, \"PUBLISHING PRINTING\", ServiceCategory.SERVICES),\n" +
            "2791, \"TYPESETTING SERVICE\", ServiceCategory.B2B_WHOLESALE),\n" +
            "2842, \"MISC CLEANING PRODUCT\", ServiceCategory.SERVICES),\n" +
            "4011, \"FREIGHT RAILROAD\", ServiceCategory.PROHIBITED),\n" +
            "4111, \"LOCAL TRANSPORTATION\", ServiceCategory.PROHIBITED),\n" +
            "4112, \"PASSENGER RAILWAY\", ServiceCategory.PROHIBITED),\n" +
            "4119, \"AMBULANCE SERVICE\", ServiceCategory.SERVICES),\n" +
            "4121, \"TAXICAB LIMOUSINE\", ServiceCategory.OTHER),\n" +
            "4131, \"BUS LINE\", ServiceCategory.OTHER),\n" +
            "4214, \"FREIGHT MOVING\", ServiceCategory.SERVICES),\n" +
            "4215, \"COURIER SERVICE\", ServiceCategory.B2B_WHOLESALE),\n" +
            "4225, \"WAREHOUSING STORAGE\", ServiceCategory.SERVICES),\n" +
            "4411, \"CRUISE LINE\", ServiceCategory.PROHIBITED),\n" +
            "4457, \"BOAT RENTAL\", ServiceCategory.SERVICES),\n" +
            "4468, \"MARINE SERVICE SUPPLY\", ServiceCategory.SERVICES),\n" +
            "4511, \"AIRLINE AIR CARRIER\", ServiceCategory.PROHIBITED),\n" +
            "4582, \"AIRPORT TERMINAL\", ServiceCategory.OTHER),\n" +
            "4784, \"TOLL BRIDGE FEE\", ServiceCategory.OTHER),\n" +
            "4789, \"MISC TRANSPORTATION\", ServiceCategory.OTHER),\n" +
            "4812, \"TELECOM EQUIPMENT\", ServiceCategory.OTHER),\n" +
            "4814, \"TELECOM SERVICE\", ServiceCategory.PROHIBITED),\n" +
            "4815, \"MONTHLY TELEPHONE\", ServiceCategory.PROHIBITED),\n" +
            "4816, \"COMPUTER NETWORK INFO\", ServiceCategory.OTHER),\n" +
            "4821, \"TELEGRAPH SERVICE\", ServiceCategory.SERVICES),\n" +
            "4829, \"WIRE XFER MONEY ORDER\", ServiceCategory.PROHIBITED),\n" +
            "4899, \"CABLE PAY TV\", ServiceCategory.OTHER),\n" +
            "4900, \"PUBLIC UTILITY\", ServiceCategory.SERVICES),\n" +
            "5013, \"AUTO SUPPLIES PARTS\", ServiceCategory.RETAIL),\n" +
            "5021, \"OFFICE FURNITURE\", ServiceCategory.RETAIL),\n" +
            "5039, \"CONSTRUCTION MATERIAL\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5044, \"OFFICE EQUIPMENT\", ServiceCategory.RETAIL),\n" +
            "5045, \"COMPUTERS EQUIPMENT\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5046, \"COMMERICAL EQUIPMENT\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5047, \"MEDICAL EQUIPMENT\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5051, \"METAL SERVICE CENTER\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5065, \"ELECTRICAL EQUIPMENT\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5072, \"HARDWARE EQUIPMENT\", ServiceCategory.RETAIL),\n" +
            "5074, \"PLUMBING HEATING\", ServiceCategory.SERVICES),\n" +
            "5085, \"INDUSTRIAL SUPPLY\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5094, \"JEWELRY WATCHES\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5099, \"DURABLE GOODS\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5111, \"OFFICE SUPPLIES\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5122, \"DRUGS\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5131, \"FABRICS\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5137, \"COMMERCIAL CLOTHING\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5139, \"COMMERCIAL FOOTWEAR\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5169, \"CHEMICALS\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5172, \"PETROLEUM PRODUCTS\", ServiceCategory.PROHIBITED),\n" +
            "5192, \"BOOKS NEWSPAPERS\", ServiceCategory.RETAIL),\n" +
            "5193, \"FLORISTS SUPPLIES\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5198, \"PAINTS VARNISHES\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5199, \"NON-DURABLE GOODS\", ServiceCategory.B2B_WHOLESALE),\n" +
            "5200, \"HOME SUPPLY WAREHOUSE\", ServiceCategory.RETAIL),\n" +
            "5211, \"LUMBER BUILDING\", ServiceCategory.RETAIL),\n" +
            "5231, \"GLASS PAINT WALLPAPER\", ServiceCategory.RETAIL),\n" +
            "5251, \"HARDWARE STORE\", ServiceCategory.RETAIL),\n" +
            "5261, \"LAWN GARDEN SUPPLIES\", ServiceCategory.RETAIL),\n" +
            "5271, \"MOBILE HOME DEALER\", ServiceCategory.SERVICES),\n" +
            "5300, \"WHOLESALE CLUB\", ServiceCategory.SERVICES),\n" +
            "5309, \"DUTY-FREE STORE\", ServiceCategory.RETAIL),\n" +
            "5310, \"DISCOUNT STORE\", ServiceCategory.RETAIL),\n" +
            "5311, \"DEPARTMENT STORE\", ServiceCategory.RETAIL),\n" +
            "5331, \"VARIETY STORE\", ServiceCategory.RETAIL),\n" +
            "5399, \"GENERAL MERCHANDISE\", ServiceCategory.RETAIL),\n" +
            "5411, \"GROCERY STORE\", ServiceCategory.RETAIL),\n" +
            "5422, \"FREEZER LOCKER MEAT\", ServiceCategory.RETAIL),\n" +
            "5441, \"CANDY CONFECTIONERY\", ServiceCategory.RETAIL),\n" +
            "5451, \"DAIRY PRODUCTS STORE\", ServiceCategory.RETAIL),\n" +
            "5462, \"BAKERY\", ServiceCategory.RETAIL),\n" +
            "5499, \"MISC FOOD STORE\", ServiceCategory.RETAIL),\n" +
            "5511, \"AUTO DEALER NEW USED\", ServiceCategory.SERVICES),\n" +
            "5521, \"AUTO DEALER USED\", ServiceCategory.SERVICES),\n" +
            "5531, \"AUTO HOME SUPPLY\", ServiceCategory.RETAIL),\n" +
            "5532, \"AUTOMOTIVE TIRE STORE\", ServiceCategory.RETAIL),\n" +
            "5533, \"AUTO PARTS ACCESSORY\", ServiceCategory.RETAIL),\n" +
            "5541, \"GAS STATION\", ServiceCategory.OTHER),\n" +
            "5542, \"AUTO FUEL DISPENSER\", ServiceCategory.OTHER),\n" +
            "5551, \"BOAT DEALER\", ServiceCategory.RETAIL),\n" +
            "5561, \"CAMPER TRAILER DEALER\", ServiceCategory.SERVICES),\n" +
            "5571, \"MOTORCYCLE DEALER\", ServiceCategory.SERVICES),\n" +
            "5592, \"MOTOR HOME DEALER\", ServiceCategory.SERVICES),\n" +
            "5598, \"SNOWMOBILE DEALER\", ServiceCategory.SERVICES),\n" +
            "5599, \"MISC VEHICLE DEALER\", ServiceCategory.SERVICES),\n" +
            "5611, \"MENS CLOTHING\", ServiceCategory.RETAIL),\n" +
            "5621, \"WOMENS CLOTHING\", ServiceCategory.RETAIL),\n" +
            "5631, \"WOMENS ACCESSORIES\", ServiceCategory.RETAIL),\n" +
            "5641, \"CHILDRENS CLOTHING\", ServiceCategory.RETAIL),\n" +
            "5651, \"FAMILY CLOTHING\", ServiceCategory.RETAIL),\n" +
            "5655, \"SPORTS CLOTHING\", ServiceCategory.RETAIL),\n" +
            "5661, \"SHOE STORE\", ServiceCategory.RETAIL),\n" +
            "5681, \"FURRIER AND FUR SHOP\", ServiceCategory.RETAIL),\n" +
            "5691, \"MENS WOMENS CLOTHNG\", ServiceCategory.RETAIL),\n" +
            "5697, \"TAILOR SEAMSTRESS\", ServiceCategory.SERVICES),\n" +
            "5698, \"WIG AND TOUPEE STORE\", ServiceCategory.RETAIL),\n" +
            "5699, \"MISC APPAREL STORE\", ServiceCategory.RETAIL),\n" +
            "5712, \"FURNITURE HOME STORE\", ServiceCategory.RETAIL),\n" +
            "5713, \"FLOOR COVERING STORE\", ServiceCategory.RETAIL),\n" +
            "5714, \"DRAPERY UPHOLSTERY\", ServiceCategory.RETAIL),\n" +
            "5715, \"WHOLESALE ALCOHOL\", ServiceCategory.RETAIL),\n" +
            "5718, \"FIREPLACE ACCESSORIES\", ServiceCategory.RETAIL),\n" +
            "5719, \"MISC HOME FURNISHINGS\", ServiceCategory.RETAIL),\n" +
            "5722, \"HOUSEHOLD APPLIANCES\", ServiceCategory.RETAIL),\n" +
            "5732, \"ELECTRONICS STORE\", ServiceCategory.RETAIL),\n" +
            "5733, \"MUSIC STORE\", ServiceCategory.RETAIL),\n" +
            "5734, \"COMPUTER STORE\", ServiceCategory.RETAIL),\n" +
            "5735, \"RECORD STORE\", ServiceCategory.RETAIL),\n" +
            "5811, \"RESTAURANT\", ServiceCategory.RESTAURANT),\n" +
            "5812, \"RESTAURANT\", ServiceCategory.RESTAURANT),\n" +
            "5813, \"RESTAURANT\", ServiceCategory.RESTAURANT),\n" +
            "5814, \"FAST FOOD RESTAURANT\", ServiceCategory.RESTAURANT),\n" +
            "5815, \"\", ServiceCategory.RETAIL),\n" +
            "5912, \"DRUG STORE PHARMACY\", ServiceCategory.RETAIL),\n" +
            "5921, \"LIQUOR STORE\", ServiceCategory.RETAIL),\n" +
            "5931, \"USED MERCHANDISE\", ServiceCategory.RETAIL),\n" +
            "5932, \"ANTIQUE SHOP\", ServiceCategory.RETAIL),\n" +
            "5933, \"PAWN SHOP\", ServiceCategory.SERVICES),\n" +
            "5935, \"WRECKING SALVAGE\", ServiceCategory.SERVICES),\n" +
            "5937, \"ANTIQUE REPRODUCTION\", ServiceCategory.RETAIL),\n" +
            "5940, \"BICYCLE SHOP\", ServiceCategory.RETAIL),\n" +
            "5941, \"SPORTING GOODS STORE\", ServiceCategory.RETAIL),\n" +
            "5942, \"BOOK STORE\", ServiceCategory.RETAIL),\n" +
            "5943, \"OFFICE SUPPLY STORE\", ServiceCategory.RETAIL),\n" +
            "5944, \"JEWELRY WATCH SILVRWR\", ServiceCategory.RETAIL),\n" +
            "5945, \"HOBBY TOY GAME\", ServiceCategory.RETAIL),\n" +
            "5946, \"CAMERA PHOTO SUPPLY\", ServiceCategory.RETAIL),\n" +
            "5947, \"CARD SOUVENIR STORE\", ServiceCategory.RETAIL),\n" +
            "5948, \"LUGGAGE LEATHER GOODS\", ServiceCategory.RETAIL),\n" +
            "5949, \"SEWING FABRIC STORE\", ServiceCategory.RETAIL),\n" +
            "5950, \"GLASSWARE CRYSTAL\", ServiceCategory.RETAIL),\n" +
            "5960, \"DIRECT MKTG INSURANCE\", ServiceCategory.PROHIBITED),\n" +
            "5962, \"DIRECT MKTG TRAVEL\", ServiceCategory.PROHIBITED),\n" +
            "5963, \"DOOR-TO-DOOR SALES\", ServiceCategory.PROHIBITED),\n" +
            "5964, \"CATALOG MERCHANDISE\", ServiceCategory.INTERNET),\n" +
            "5965, \"CATALOG SHOWROOM\", ServiceCategory.SERVICES),\n" +
            "5966, \"TELEMARKETING MDSE\", ServiceCategory.PROHIBITED),\n" +
            "5967, \"DIRECT MKTG INTERNET\", ServiceCategory.PROHIBITED),\n" +
            "5968, \"SUBSCRIPTIONS\", ServiceCategory.INTERNET),\n" +
            "5969, \"DIRECT MKTG MISC\", ServiceCategory.SERVICES),\n" +
            "5970, \"ARTIST SUPPLY CRAFT\", ServiceCategory.RETAIL),\n" +
            "5971, \"ART DEALER GALLERY\", ServiceCategory.RETAIL),\n" +
            "5972, \"STAMP COIN STORE\", ServiceCategory.RETAIL),\n" +
            "5973, \"RELIGIOUS GOODS STORE\", ServiceCategory.RETAIL),\n" +
            "5975, \"HEARING AIDS\", ServiceCategory.SERVICES),\n" +
            "5976, \"ORTHOPEDIC PROSTHETIC\", ServiceCategory.SERVICES),\n" +
            "5977, \"COSMETIC STORE\", ServiceCategory.RETAIL),\n" +
            "5978, \"TYPEWRITER STORE\", ServiceCategory.RETAIL),\n" +
            "5983, \"FUEL DEALER\", ServiceCategory.SERVICES),\n" +
            "5992, \"FLORIST\", ServiceCategory.RETAIL),\n" +
            "5993, \"CIGAR STORE STAND\", ServiceCategory.RETAIL),\n" +
            "5994, \"NEWS DEALER NEWSSTAND\", ServiceCategory.RETAIL),\n" +
            "5995, \"PET SHOP FOOD SUPPLY\", ServiceCategory.RETAIL),\n" +
            "5996, \"SWIMMING POOLS\", ServiceCategory.RETAIL),\n" +
            "5997, \"ELECTRIC RAZOR STORE\", ServiceCategory.RETAIL),\n" +
            "5998, \"TENT AND AWNING STORE\", ServiceCategory.RETAIL),\n" +
            "5999, \"MISC SPECIALTY RETAIL\", ServiceCategory.RETAIL),\n" +
            "6010, \"FINANCIAL - TELLER\", ServiceCategory.PROHIBITED),\n" +
            "6011, \"FINANCIAL - ATM\", ServiceCategory.PROHIBITED),\n" +
            "6012, \"FINANCIAL - SERVICE\", ServiceCategory.PROHIBITED),\n" +
            "6051, \"NON FINANCIAL INST\", ServiceCategory.PROHIBITED),\n" +
            "6211, \"SECURITY BROKER\", ServiceCategory.PROHIBITED),\n" +
            "6300, \"INSURANCE SALES\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7012, \"TIMESHARE\", ServiceCategory.PROHIBITED),\n" +
            "7032, \"RECREATION CAMP\", ServiceCategory.EDUCATION),\n" +
            "7210, \"CLEANING GARMENT\", ServiceCategory.SERVICES),\n" +
            "7211, \"LAUNDRY SERVICE\", ServiceCategory.SERVICES),\n" +
            "7216, \"DRY CLEANER\", ServiceCategory.SERVICES),\n" +
            "7217, \"CARPET CLEANING\", ServiceCategory.SERVICES),\n" +
            "7221, \"PHOTOGRAPHIC STUDIO\", ServiceCategory.SERVICES),\n" +
            "7230, \"BEAUTY BARBER SHOP\", ServiceCategory.SERVICES),\n" +
            "7251, \"SHOE REPAIR SHINE\", ServiceCategory.SERVICES),\n" +
            "7261, \"FUNERAL SERVICE\", ServiceCategory.SERVICES),\n" +
            "7273, \"DATING SERVICE\", ServiceCategory.PROHIBITED),\n" +
            "7276, \"TAX PREPARATION\", ServiceCategory.SERVICES),\n" +
            "7277, \"COUNSELING SERVICE\", ServiceCategory.SERVICES),\n" +
            "7278, \"BUYING SHOPPING CLUBS\", ServiceCategory.SERVICES),\n" +
            "7296, \"CLOTHING RENTAL\", ServiceCategory.RETAIL),\n" +
            "7297, \"MASSAGE PARLOR\", ServiceCategory.PROHIBITED),\n" +
            "7298, \"HEALTH BEAUTY SPA\", ServiceCategory.SERVICES),\n" +
            "7299, \"MISC PERSONAL SERVICE\", ServiceCategory.SERVICES),\n" +
            "7311, \"ADVERTISING SERVICE\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7321, \"CREDIT REPORTING\", ServiceCategory.SERVICES),\n" +
            "7322, \"DEBT COLLECTION\", ServiceCategory.PROHIBITED),\n" +
            "7333, \"COMMERCIAL PHOTO ART\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7338, \"COPY REPRODUCTION \", ServiceCategory.B2B_WHOLESALE),\n" +
            "7339, \"SECRETARIAL SUPPORT\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7342, \"EXTERMINATE DISINFECT\", ServiceCategory.SERVICES),\n" +
            "7349, \"CLEANING JANITORIAL\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7361, \"EMPLOYMENT AGENCY\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7372, \"COMPUTER PROGRAMMING\", ServiceCategory.SERVICES),\n" +
            "7375, \"INFORMATION RETRIEVAL\", ServiceCategory.SERVICES),\n" +
            "7379, \"COMPUTER MAINTENANCE\", ServiceCategory.SERVICES),\n" +
            "7392, \"MGMT CONSULTING PR\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7393, \"SECURITY SERVICE\", ServiceCategory.SERVICES),\n" +
            "7394, \"EQUIPMENT RENTAL\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7395, \"PHOTO FINISHING\", ServiceCategory.SERVICES),\n" +
            "7399, \"BUSINESS SERVICE\", ServiceCategory.B2B_WHOLESALE),\n" +
            "742, \"VETERINARY SERVICE\", ServiceCategory.SERVICES),\n" +
            "743, \"WINE PRODUCER\", ServiceCategory.SERVICES),\n" +
            "744, \"CHAMPAGNE PRODUCER\", ServiceCategory.SERVICES),\n" +
            "7512, \"AUTOMOBILE RENTAL\", ServiceCategory.PROHIBITED),\n" +
            "7513, \"TRUCK RENTAL\", ServiceCategory.PROHIBITED),\n" +
            "7519, \"MOTOR HOME RV RENTAL\", ServiceCategory.PROHIBITED),\n" +
            "7523, \"PARKING LOT GARAGE\", ServiceCategory.SERVICES),\n" +
            "7531, \"AUTO BODY REPAIR\", ServiceCategory.SERVICES),\n" +
            "7534, \"TIRE REPAIR\", ServiceCategory.SERVICES),\n" +
            "7535, \"AUTO PAINT SHOP\", ServiceCategory.SERVICES),\n" +
            "7538, \"AUTO SERVICE\", ServiceCategory.SERVICES),\n" +
            "7542, \"CAR WASH\", ServiceCategory.SERVICES),\n" +
            "7549, \"TOWING SERVICE\", ServiceCategory.SERVICES),\n" +
            "7622, \"ELECTRONICS REPAIR\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7623, \"AC REFRIG REPAIR\", ServiceCategory.SERVICES),\n" +
            "7629, \"APPLIANCE REPAIR\", ServiceCategory.SERVICES),\n" +
            "763, \"AGRICULTURAL CO-OP\", ServiceCategory.SERVICES),\n" +
            "7631, \"WATCH JEWELRY REPAIR\", ServiceCategory.RETAIL),\n" +
            "7641, \"FURNITURE REPAIR\", ServiceCategory.SERVICES),\n" +
            "7692, \"WELDING SERVICE\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7699, \"MISC REPAIR SHOP\", ServiceCategory.SERVICES),\n" +
            "780, \"LANDSCAPE HORTICULTURE \", ServiceCategory.B2B_WHOLESALE),\n" +
            "7829, \"VIDEO PRODUCTION\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7832, \"MOVIE THEATER\", ServiceCategory.SERVICES),\n" +
            "7841, \"VIDEO RENTAL STORE\", ServiceCategory.RETAIL),\n" +
            "7911, \"DANCE HALL SCHOOL\", ServiceCategory.EDUCATION),\n" +
            "7922, \"TICKET AGENCY\", ServiceCategory.SERVICES),\n" +
            "7929, \"MISC ENTERTAINER\", ServiceCategory.SERVICES),\n" +
            "7932, \"BILLIARD POOL\", ServiceCategory.SERVICES),\n" +
            "7933, \"BOWLING ALLEY\", ServiceCategory.SERVICES),\n" +
            "7941, \"COMMERCIAL SPORTS\", ServiceCategory.B2B_WHOLESALE),\n" +
            "7991, \"TOURIST ATTRACTION\", ServiceCategory.SERVICES),\n" +
            "7992, \"PUBLIC GOLF COURSE\", ServiceCategory.SERVICES),\n" +
            "7993, \"VIDEO GAME SUPPLY\", ServiceCategory.SERVICES),\n" +
            "7994, \"VIDEO GAME ARCADE\", ServiceCategory.SERVICES),\n" +
            "7997, \"MEMBERSHIP CLUB\", ServiceCategory.SERVICES),\n" +
            "7998, \"AQUARIUM\", ServiceCategory.SERVICES),\n" +
            "8011, \"DOCTOR PHYSICIAN\", ServiceCategory.HEALTHCARE_PRACTITONER),\n" +
            "8021, \"DENTIST ORTHODONTIST\", ServiceCategory.HEALTHCARE_PRACTITONER),\n" +
            "8031, \"OSTEOPATH\", ServiceCategory.HEALTHCARE),\n" +
            "8041, \"CHIROPRACTOR\", ServiceCategory.HEALTHCARE),\n" +
            "8042, \"OPTOMETRIST\", ServiceCategory.HEALTHCARE),\n" +
            "8043, \"OPTICIAN\", ServiceCategory.HEALTHCARE),\n" +
            "8049, \"PODIATRIST\", ServiceCategory.HEALTHCARE),\n" +
            "8050, \"NURSING PERSONAL CARE\", ServiceCategory.HEALTHCARE),\n" +
            "8062, \"HOSPITAL\", ServiceCategory.HEALTHCARE),\n" +
            "8071, \"MEDICAL DENTAL LAB\", ServiceCategory.HEALTHCARE),\n" +
            "8099, \"MEDICAL SERVICE\", ServiceCategory.HEALTHCARE),\n" +
            "8111, \"LEGAL SERVICE\", ServiceCategory.SERVICES),\n" +
            "8211, \"SCHOOL\", ServiceCategory.EDUCATION),\n" +
            "8220, \"COLLEGE UNIVERSITY\", ServiceCategory.EDUCATION),\n" +
            "8241, \"CORRESPONDENCE SCHOOL\", ServiceCategory.EDUCATION),\n" +
            "8244, \"SECRETARIAL SCHOOL\", ServiceCategory.EDUCATION),\n" +
            "8249, \"TRADE VOCATION SCHOOL\", ServiceCategory.EDUCATION),\n" +
            "8299, \"EDUCATIONAL SERVICE\", ServiceCategory.EDUCATION),\n" +
            "8351, \"CHILD CARE SERVICE\", ServiceCategory.EDUCATION),\n" +
            "8398, \"CHARITABLE ORG\", ServiceCategory.OTHER),\n" +
            "8641, \"CIVIC SOCIAL ASSOC\", ServiceCategory.SERVICES),\n" +
            "8651, \"POLITICAL ORG\", ServiceCategory.SERVICES),\n" +
            "8661, \"RELIGIOUS ORG\", ServiceCategory.OTHER),\n" +
            "8675, \"AUTOMOBILE ASSOC\", ServiceCategory.SERVICES),\n" +
            "8699, \"MEMBERSHIP ORGS\", ServiceCategory.SERVICES),\n" +
            "8734, \"TESTING LABORATORY\", ServiceCategory.B2B_WHOLESALE),\n" +
            "8911, \"ARCHITECT ENGINEER\", ServiceCategory.B2B_WHOLESALE),\n" +
            "8931, \"ACCOUNTING AUDITING\", ServiceCategory.B2B_WHOLESALE),\n" +
            "8999, \"PROFESSIONAL SERVICE\", ServiceCategory.B2B_WHOLESALE),\n" +
            "9211, \"COURT COSTS\", ServiceCategory.GOVERNMENT),\n" +
            "9222, \"FINE\", ServiceCategory.GOVERNMENT),\n" +
            "9223, \"BAIL AND BOND PAYMENT\", ServiceCategory.GOVERNMENT),\n" +
            "9311, \"TAX PAYMENT\", ServiceCategory.GOVERNMENT),\n" +
            "9399, \"GOVERNMENT SERVICE\", ServiceCategory.GOVERNMENT),\n" +
            "9402, \"POSTAL SERVICE\", ServiceCategory.PROHIBITED)";

    String pairs = "742,6544840838\n" +
            "743,6544840812\n" +
            "744,6544840812\n" +
            "763,6544840812\n" +
            "780,6544840804\n" +
            "1520,6544840812\n" +
            "1711,6544840812\n" +
            "1731,6544840812\n" +
            "1740,6544840812\n" +
            "1750,6544840812\n" +
            "1761,6544840812\n" +
            "1771,6544840812\n" +
            "1799,6544840804\n" +
            "2741,6544840812\n" +
            "2791,6544840804\n" +
            "2842,6544840812\n" +
            "4111,6544840820\n" +
            "4112,6544840820\n" +
            "4119,6544840838\n" +
            "4121,6544840820\n" +
            "4131,6544840820\n" +
            "4214,6544840812\n" +
            "4011,6544840804\n" +
            "4215,6544840804\n" +
            "4225,6544840812\n" +
            "4457,6544840812\n" +
            "4468,6544840812\n" +
            "4582,6544840820\n" +
            "4722,Prohibited for PayFacs\n" +
            "4784,1548293893\n" +
            "4789,6544840820\n" +
            "4812,6544840853\n" +
            "4816,6544840812\n" +
            "4821,6544840812\n" +
            "4899,6544840853\n" +
            "4900,6544840812\n" +
            "5013,6544840796\n" +
            "5021,6544840796\n" +
            "5039,6544840804\n" +
            "5044,6544840796\n" +
            "5045,6544840804\n" +
            "5046,6544840804\n" +
            "5047,6544840804\n" +
            "5051,6544840804\n" +
            "5065,6544840804\n" +
            "5072,6544840796\n" +
            "5074,6544840812\n" +
            "5085,6544840804\n" +
            "5094,6544840804\n" +
            "5099,6544840804\n" +
            "5111,6544840804\n" +
            "5122,6544840796\n" +
            "5131,6544840804\n" +
            "5137,6544840804\n" +
            "5139,6544840804\n" +
            "5169,6544840804\n" +
            "5192,6544840796\n" +
            "5172,6544840804\n" +
            "5193,6544840796\n" +
            "5198,6544840804\n" +
            "5199,6544840804\n" +
            "5200,6544840796\n" +
            "5211,6544840796\n" +
            "5231,6544840796\n" +
            "5251,6544840796\n" +
            "5261,6544840796\n" +
            "5271,6544840812\n" +
            "5300,6544840796\n" +
            "5309,6544840796\n" +
            "5310,6544840796\n" +
            "5311,6544840796\n" +
            "5331,6544840796\n" +
            "5399,6544840796\n" +
            "5411,6544840796\n" +
            "5422,6544840796\n" +
            "5441,6544840796\n" +
            "5451,6544840796\n" +
            "5462,6544840796\n" +
            "5499,6544840796\n" +
            "5511,6544840812\n" +
            "5521,6544840812\n" +
            "5531,6544840796\n" +
            "5532,6544840796\n" +
            "5533,6544840796\n" +
            "5541,6544840853\n" +
            "5542,6544840853\n" +
            "5551,6544840796\n" +
            "5561,6544840812\n" +
            "5571,6544840812\n" +
            "5592,6544840812\n" +
            "5598,6544840812\n" +
            "5599,6544840812\n" +
            "5611,6544840796\n" +
            "5621,6544840796\n" +
            "5631,6544840796\n" +
            "5641,6544840796\n" +
            "5651,6544840796\n" +
            "5655,6544840796\n" +
            "5661,6544840796\n" +
            "5681,6544840796\n" +
            "5691,6544840796\n" +
            "5697,6544840812\n" +
            "5698,6544840796\n" +
            "5699,6544840796\n" +
            "5712,6544840796\n" +
            "5713,6544840796\n" +
            "5714,6544840796\n" +
            "5715,6544840796\n" +
            "5718,6544840796\n" +
            "5719,6544840796\n" +
            "5722,6544840796\n" +
            "5732,6544840796\n" +
            "5733,6544840796\n" +
            "5734,6544840796\n" +
            "5735,6544840796\n" +
            "5811,6544840770\n" +
            "5812,6544840770\n" +
            "5813,6544840770\n" +
            "5814,6544840770\n" +
            "5815,6544840796\n" +
            "5816,6544840796\n" +
            "5817,6544840796\n" +
            "5818,6544840796\n" +
            "5912,6544840796\n" +
            "5921,6544840796\n" +
            "5931,6544840796\n" +
            "5932,6544840796\n" +
            "5933,6544840812\n" +
            "5935,6544840812\n" +
            "5937,6544840796\n" +
            "5940,6544840796\n" +
            "5941,6544840796\n" +
            "5942,6544840796\n" +
            "5943,6544840796\n" +
            "5944,6544840796\n" +
            "5945,6544840796\n" +
            "5946,6544840796\n" +
            "5947,6544840796\n" +
            "5948,6544840796\n" +
            "5949,6544840796\n" +
            "5950,6544840796\n" +
            "5960, 5548346659\n" +
            "5964,6544840812\n" +
            "5965,6544840796\n" +
            "5968, 5548346659\n" +
            "5969,6544840812\n" +
            "5970,6544840796\n" +
            "5971,6544840796\n" +
            "5972,6544840796\n" +
            "5973,6544840796\n" +
            "5975,6544840812\n" +
            "5976,6544840812\n" +
            "5977,6544840796\n" +
            "5978,6544840796\n" +
            "5983,6544840812\n" +
            "5992,6544840796\n" +
            "5993,6544840796\n" +
            "5994,6544840796\n" +
            "5995,6544840796\n" +
            "5996,6544840796\n" +
            "5997,6544840796\n" +
            "5998,6544840796\n" +
            "5999,6544840796\n" +
            "6300, 5548346659\n" +
            "6513,6544840812\n" +
            "7011,Prohibited for PayFacs\n" +
            "7032,1548293885\n" +
            "7033,6544840820\n" +
            "7210,6544840812\n" +
            "7211,6544840812\n" +
            "7216,6544840812\n" +
            "7217,6544840812\n" +
            "7221,6544840812\n" +
            "7230,6544840812\n" +
            "7251,6544840812\n" +
            "7261,6544840812\n" +
            "7273,6544840812\n" +
            "7276,6544840812\n" +
            "7277,6544840812\n" +
            "7278,6544840812\n" +
            "7296,6544840796\n" +
            "7297,6544840812\n" +
            "7298,6544840812\n" +
            "7299,6544840812\n" +
            "7311,6544840804\n" +
            "7321,6544840812\n" +
            "7333,6544840804\n" +
            "7338,6544840804\n" +
            "7339,6544840804\n" +
            "7342,6544840812\n" +
            "7349,6544840804\n" +
            "7361,6544840804\n" +
            "7372,6544840812\n" +
            "7375,6544840812\n" +
            "7379,6544840812\n" +
            "7392,6544840804\n" +
            "7393,6544840812\n" +
            "7394,6544840804\n" +
            "7395,6544840812\n" +
            "7399,6544840804\n" +
            "7512,6544840820\n" +
            "7513,6544840812\n" +
            "7519,6544840812\n" +
            "7523,6544840812\n" +
            "7531,6544840812\n" +
            "7534,6544840812\n" +
            "7535,6544840812\n" +
            "7538,6544840812\n" +
            "7542,6544840812\n" +
            "7549,6544840812\n" +
            "7622,6544840796\n" +
            "7623,6544840812\n" +
            "7629,6544840812\n" +
            "7631,6544840796\n" +
            "7641,6544840812\n" +
            "7692,6544840804\n" +
            "7699,6544840812\n" +
            "7829,6544840804\n" +
            "7832,6544840820\n" +
            "7841,6544840796\n" +
            "7911,1548293885\n" +
            "7922,6544840820\n" +
            "7929,6544840820\n" +
            "7932,6544840820\n" +
            "7933,6544840820\n" +
            "7941,6544840820\n" +
            "7991,6544840820\n" +
            "7992,6544840820\n" +
            "7993,6544840820\n" +
            "7994,6544840820\n" +
            "7996,6544840820\n" +
            "7997,6544840812\n" +
            "7998,6544840820\n" +
            "7999,6544840820\n" +
            "8011,6544840838\n" +
            "8021,6544840838\n" +
            "8031,6544840838\n" +
            "8041,6544840838\n" +
            "8042,6544840838\n" +
            "8043,6544840838\n" +
            "8049,6544840838\n" +
            "8050,6544840838\n" +
            "8062,6544840838\n" +
            "8071,6544840838\n" +
            "8099,6544840838\n" +
            "8111,6544840812\n" +
            "8211, 5548346659\n" +
            "8220, 5548346659\n" +
            "8241,1548293885\n" +
            "8244,1548293885\n" +
            "8249,1548293885\n" +
            "8299,1548293885\n" +
            "8351, 5548346659\n" +
            "8398, 5548346659\n" +
            "8641,6544840812\n" +
            "8651,6544840853\n" +
            "8661,6544840853\n" +
            "8675,6544840812\n" +
            "8699,6544840812\n" +
            "8734,6544840804\n" +
            "8911,6544840804\n" +
            "8931,6544840804\n" +
            "8999,6544840804\n" +
            "9211, 5548346659\n" +
            "9222, 5548346659\n" +
            "9223,1548293893\n" +
            "9311,1548293893\n" +
            "9399, 5548346659";
}
