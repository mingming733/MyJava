import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CmsSe {

    public void getMapping() {
        Map<String, String> map = new TreeMap<>();
        String[] pairs = SeToSc.split("\n");
        for (String pair : pairs) {
            String[] pairArr = pair.split("\t");
            map.put(pairArr[0], pairArr[1]);
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public void process() {
        StringBuilder result = new StringBuilder();
        String[] strings = target.split("[^\\w']+");
        int n = strings.length;
        for (int i = 0; i < strings.length - 1; i++) {
            if (strings[i].equals("ServiceCategory")) {
                result.append(strings[i + 1]).append(" ");
            } else if (strings[i].equals("CMS_AMEX_US")) {
                result.append(strings[i + 1]).append("\n");
            }
        }
        System.out.println(result.toString());
    }

    String target = "add(ServiceCategory.INTERNET,\n" +
            "                pair(OFOF, 1048483937L),\n" +
            "                pair(NFOF, 2044302172L),\n" +
            "                pair(CA_AMEX, 9323790676L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542462940L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840861L),\n" +
            "                pair(CMS_AMEX_US, 2280917253L));\n" +
            "        add(ServiceCategory.RETAIL,\n" +
            "                pair(OFOF, 2046219887L),\n" +
            "                pair(NFOF, 2044933141L),\n" +
            "                pair(CA_AMEX, 9323770538L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457627L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840796L),\n" +
            "                pair(CMS_AMEX_US, 2280917188L));\n" +
            "        add(ServiceCategory.HEALTHCARE,\n" +
            "                pair(OFOF, 2046219945L),\n" +
            "                pair(NFOF, 2044933216L),\n" +
            "                pair(CA_AMEX, 9323790684L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457692L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840838L),\n" +
            "                pair(CMS_AMEX_US, 2280917238L));\n" +
            "        add(ServiceCategory.SERVICES,\n" +
            "                pair(OFOF, 2046219978L),\n" +
            "                pair(NFOF, 2044933166L),\n" +
            "                pair(CA_AMEX, 9323790650L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457668L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840812L),\n" +
            "                pair(CMS_AMEX_US, 2280917204L));\n" +
            "        add(ServiceCategory.HEALTHCARE_PRACTITONER,\n" +
            "                pair(OFOF, 2046219994L),\n" +
            "                pair(NFOF, 2044933224L),\n" +
            "                pair(CA_AMEX, 9323790692L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457692L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840838L),\n" +
            "                pair(CMS_AMEX_US, 2280917238L));\n" +
            "        add(ServiceCategory.RESTAURANT,\n" +
            "                pair(OFOF, 2046220018L),\n" +
            "                pair(NFOF, 2044933133L),\n" +
            "                pair(CA_AMEX, 9323790668L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457643L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840770L),\n" +
            "                pair(CMS_AMEX_US, 2280917162L));\n" +
            "        add(ServiceCategory.B2B_WHOLESALE,\n" +
            "                pair(OFOF, 2046220042L),\n" +
            "                pair(NFOF, 2044933158L),\n" +
            "                pair(CA_AMEX, 9323790700L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457700L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840804L),\n" +
            "                pair(CMS_AMEX_US, 2280917196L));\n" +
            "        add(ServiceCategory.CATER_DRINK,\n" +
            "                pair(OFOF, 2046220059L),\n" +
            "                pair(NFOF, 2044933265L),\n" +
            "                pair(CA_AMEX, 9323790668L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457676L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840788L),\n" +
            "                pair(CMS_AMEX_US, 2280917170L));\n" +
            "        add(ServiceCategory.OTHER,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542460035L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840853L),\n" +
            "                pair(CMS_AMEX_US, 2280917246L));\n" +
            "        add(ServiceCategory.PROHIBITED,\n" +
            "                pair(OFOF, 2046220521L),\n" +
            "                pair(NFOF, 2044933232L),\n" +
            "                pair(CA_AMEX, 9323790718L),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542460035L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840853L),\n" +
            "                pair(CMS_AMEX_US, 2280917246L));\n" +
            "        add(ServiceCategory.GOVERNMENT,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 1546508698L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 1548293893L),\n" +
            "                pair(CMS_AMEX_US, 2281568592L));\n" +
            "        add(ServiceCategory.EDUCATION,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 1546508706L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 1548293885L),\n" +
            "                pair(CMS_AMEX_US, 2281568584L));\n" +
            "        add(ServiceCategory.EMERGING_MARKETS,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 5541556163L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 5548346659L),\n" +
            "                pair(CMS_AMEX_US, 2282240050L));\n" +
            "        add(ServiceCategory.T_AND_E,\n" +
            "                pair(OFOF, SERVICE_CATEGORY_OTHER_OFOF),\n" +
            "                pair(NFOF, SERVICE_CATEGORY_OTHER_NFOF),\n" +
            "                pair(CA_AMEX, SERVICE_CATEGORY_OTHER_CA_AMEX),\n" +
            "                pair(VANTIV_AMEX_OPTBLUE, 6542457684L),\n" +
            "                pair(LITLE_AMEX_OPTBLUE, 6544840820L),\n" +
            "                pair(CMS_AMEX_US, 2280917212L));";

    String SeToSc = "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "N/A\tServices\n" +
            "N/A\tServices\n" +
            "N/A\tServices\n" +
            "N/A\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "N/A\tOther\n" +
            "N/A\tOther\n" +
            "N/A\tOther\n" +
            "N/A\tOther\n" +
            "N/A\tOther\n" +
            "N/A\tOther\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904453\tTravel and Entertainment\n" +
            "2280917212\tTravel and Entertainment\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "N/A\tB2B/Wholesale\n" +
            "N/A\tB2B/Wholesale\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "N/A\tRetail\n" +
            "N/A\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904412\tRestaurant\n" +
            "2280917170\tCaterers and Drinking Places\n" +
            "9303904412\tRestaurant\n" +
            "2280917162\tRestaurant\n" +
            "9303904412\tRestaurant\n" +
            "2280917170\tCaterers and Drinking Places\n" +
            "9303904412\tRestaurant\n" +
            "2280917162\tRestaurant\n" +
            "9303904495\tMail Order and Internet\n" +
            "2280917253\tMail Order and Internet\n" +
            "9303904495\tMail Order and Internet\n" +
            "2280917253\tMail Order and Internet\n" +
            "9303904495\tMail Order and Internet\n" +
            "2280917253\tMail Order and Internet\n" +
            "N/A\tMail Order and Internet\n" +
            "N/A\tMail Order and Internet\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904495\tMail Order and Internet\n" +
            "2280917253\tMail Order and Internet\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904495\tMail Order and Internet\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904495\tMail Order and Internet\n" +
            "2280917253\tMail Order and Internet\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904453\tTravel and Entertainment\n" +
            "2280917220\tLodging\n" +
            "9303904487\tOther\n" +
            "2281568584\tEducation\n" +
            "9303904453\tTravel and Entertainment\n" +
            "2280917212\tTravel and Entertainment\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904453\tTravel and Entertainment\n" +
            "2280917212\tTravel and Entertainment\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904420\tRetail\n" +
            "2280917188\tRetail\n" +
            "9303904446\tServices\n" +
            "2281568584\tEducation\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904453\tTravel and Entertainment\n" +
            "2280917212\tTravel and Entertainment\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904453\tTravel and Entertainment\n" +
            "2280917212\tTravel and Entertainment\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904479\tHealthcare\n" +
            "2280917238\tHealthcare\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904487\tOther\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904487\tOther\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904487\tOther\n" +
            "2281568584\tEducation\n" +
            "9303904487\tOther\n" +
            "2281568584\tEducation\n" +
            "9303904487\tOther\n" +
            "2280917246\tEducation\n" +
            "9303904487\tOther\n" +
            "2280917246\tEducation\n" +
            "9303904487\tOther\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904487\tOther\n" +
            "2280917246\tOther\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904446\tServices\n" +
            "2280917204\tServices\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904438\tB2B/Wholesale\n" +
            "2280917196\tB2B/Wholesale\n" +
            "9303904487\tOther\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904487\tOther\n" +
            "2282240050\tEmerging Markets\n" +
            "9303904446\tServices\n" +
            "2281568592\tGovernment\n" +
            "9303904487\tOther\n" +
            "2281568592\tGovernment\n" +
            "9303904487\tOther\n" +
            "2282240050\tEmerging Markets";
}
