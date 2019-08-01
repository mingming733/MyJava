import com.sun.glass.ui.mac.MacFileNSURL;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ChaseISE {
    Set<String> mcc = new HashSet<>();
    HashMap<String, String> mccToSc = new HashMap<>();
    HashMap<String, String> mccToScOld = new HashMap<>();
    String ISEMAPPING = "ChaseISE.txt";
    String MCCS = "Mcc.txt";
    String LITLEMAPPING = "CMCC_MappingToCategory_Updated.txt";
    String MERCHANTCATEGORY = "MerchantCategory.txt";
    public void getMcc() {
        File file = new File(MERCHANTCATEGORY);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
//                for (String str: st.split(",")) {
//                    mcc.add(str.trim());
//                }
                String[] strs = st.split("\t");
                mccToSc.put(strs[0], strs[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//    System.out.println(mcc.size());
    }

    public void getMccToSc() {
        String[] lines = merchantCategory.split("\n");
        for (String line : lines) {
            String[] strs = line.split("\t");
            mccToSc.put(strs[0], strs[2]);
        }
    }
    public void getMccToScOld() {
        String[] lines = merchantCategoryOld.split("\n");
        for (String line : lines) {
            String[] strs = line.split("\t");
            mccToScOld.put(strs[0], strs[2]);
        }
    }

    // check the difference between code and sheet US
    public void getMapping() {
        getMccToSc();
        File file = new File(LITLEMAPPING);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                String[] strs = st.split("\t");
                if (mccToSc.containsKey(strs[0])) {
                    System.out.println(strs[0] + ", " + mccToSc.get(strs[0]));
                    System.out.println(strs[0] + ", " + strs[2] + "\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // find the difference between code and sheet CA
    public void getDiff() {
        getMccToScOld();
        File file = new File(ISEMAPPING);
        BufferedReader br;
        int count = 0;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null){
                String[] strs = st.split("\t");
                //print all including different
//                if (mccToScOld.containsKey(strs[0]) && st.contains("Canada")) {
//                    System.out.println(strs[0] + ", " + mccToScOld.get(strs[0]));
//                    System.out.println(strs[0] + ", " + strs[7] + "\n");
//                    count++;
//                }

                //only print different
                String oldCate = mccToScOld.get(strs[0]);
                if (mccToScOld.containsKey(strs[0])
//                        && !oldCate.substring(oldCate.length() - 6, oldCate.length() - 1).equalsIgnoreCase(strs[1].substring(strs[1].length() - 5))
                ) {
                    System.out.println(strs[0] + ", " + oldCate);
                    System.out.println(strs[0] + ", " + strs[1] + "\n");
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getISEMapping() {
        getMccToSc();
        File file = new File(ISEMAPPING);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            int count = 0;
            while ((st = br.readLine()) != null){
                String[] strs = st.split("\t");
                if (st.contains("\tCanada\t") && mccToSc.containsKey(strs[0])) {
                    System.out.println(strs[0] + ", " + strs[7]);
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // check why some mcc is in our code but not in sheet, turns out they are all prohibited
    public void notInSheet() {
        // mcc in the sheet
        File file = new File(ISEMAPPING);
        BufferedReader br;
        Set<String> setInSheet = new HashSet<>();
        try {
            br = new BufferedReader(new FileReader(file));
            String st;
            int count = 0;
            while ((st = br.readLine()) != null){
                String[] strs = st.split("\t");
                if (st.contains("\tCanada\t")) {
                    setInSheet.add(strs[0]);
                    count++;
                }
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }


        // mcc in the code
        String[] lines = merchantCategory.split("\n");
        for (String line : lines) {
            String[] strs = line.split("\t");
            if (!setInSheet.contains(strs[0])) {
                System.out.println(line);
            }
        }
    }


    String merchantCategory = "0\tUNKNOWN\tServiceCategory.OTHER)\t\n" +
            "742\tVETERINARY SERVICE\tServiceCategory.SERVICES)\t\n" +
            "743\tWINE PRODUCER\tServiceCategory.SERVICES)\t\n" +
            "744\tCHAMPAGNE PRODUCER\tServiceCategory.SERVICES)\t\n" +
            "763\tAGRICULTURAL CO-OP\tServiceCategory.SERVICES)\t\n" +
            "780\tLANDSCAPE HORTICULTURE \tServiceCategory.B2B_WHOLESALE)\t\n" +
            "1520\tGENERAL CONTRACTOR\tServiceCategory.SERVICES)\t\n" +
            "1711\tHEATING PLUMBING AC\tServiceCategory.SERVICES)\t\n" +
            "1731\tELECTRICAL CONTRACTOR\tServiceCategory.SERVICES)\t\n" +
            "1740\tMASONRY TILE INSULATE\tServiceCategory.SERVICES)\t\n" +
            "1750\tCARPENTRY CONTRACTOR\tServiceCategory.SERVICES)\t\n" +
            "1761\tROOFING SIDING\tServiceCategory.SERVICES)\t\n" +
            "1771\tCONCRETE WORK\tServiceCategory.SERVICES)\t\n" +
            "1799\tMISC CONTRACTOR\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "2741\tPUBLISHING PRINTING\tServiceCategory.SERVICES)\t\n" +
            "2791\tTYPESETTING SERVICE\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "2842\tMISC CLEANING PRODUCT\tServiceCategory.SERVICES)\t\n" +
            "4011\tFREIGHT RAILROAD\tServiceCategory.T_AND_E)\t\n" +
            "4111\tLOCAL TRANSPORTATION\tServiceCategory.T_AND_E)\t\n" +
            "4112\tPASSENGER RAILWAY\tServiceCategory.T_AND_E)\t\n" +
            "4119\tAMBULANCE SERVICE\tServiceCategory.HEALTHCARE)\t\n" +
            "4121\tTAXICAB LIMOUSINE\tServiceCategory.T_AND_E)\t\n" +
            "4131\tBUS LINE\tServiceCategory.T_AND_E)\t\n" +
            "4214\tFREIGHT MOVING\tServiceCategory.SERVICES)\t\n" +
            "4215\tCOURIER SERVICE\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "4225\tWAREHOUSING STORAGE\tServiceCategory.SERVICES)\t\n" +
            "4411\tCRUISE LINE\tServiceCategory.PROHIBITED)\t\n" +
            "4457\tBOAT RENTAL\tServiceCategory.SERVICES)\t\n" +
            "4468\tMARINE SERVICE SUPPLY\tServiceCategory.SERVICES)\t\n" +
            "4511\tAIRLINE AIR CARRIER\tServiceCategory.PROHIBITED)\t\n" +
            "4582\tAIRPORT TERMINAL\tServiceCategory.T_AND_E)\t\n" +
            "4784\tTOLL BRIDGE FEE\tServiceCategory.GOVERNMENT)\t\n" +
            "4789\tMISC TRANSPORTATION\tServiceCategory.T_AND_E)\t\n" +
            "4812\tTELECOM EQUIPMENT\tServiceCategory.OTHER)\t\n" +
            "4814\tTELECOM SERVICE\tServiceCategory.PROHIBITED)\t\n" +
            "4815\tMONTHLY TELEPHONE\tServiceCategory.PROHIBITED)\t\n" +
            "4816\tCOMPUTER NETWORK INFO\tServiceCategory.SERVICES)\t\n" +
            "4821\tTELEGRAPH SERVICE\tServiceCategory.SERVICES)\t\n" +
            "4829\tWIRE XFER MONEY ORDER\tServiceCategory.PROHIBITED)\t\n" +
            "4899\tCABLE PAY TV\tServiceCategory.OTHER)\t\n" +
            "4900\tPUBLIC UTILITY\tServiceCategory.SERVICES)\t\n" +
            "5013\tAUTO SUPPLIES PARTS\tServiceCategory.RETAIL)\t\n" +
            "5021\tOFFICE FURNITURE\tServiceCategory.RETAIL)\t\n" +
            "5039\tCONSTRUCTION MATERIAL\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5044\tOFFICE EQUIPMENT\tServiceCategory.RETAIL)\t\n" +
            "5045\tCOMPUTERS EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5046\tCOMMERICAL EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5047\tMEDICAL EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5051\tMETAL SERVICE CENTER\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5065\tELECTRICAL EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5072\tHARDWARE EQUIPMENT\tServiceCategory.RETAIL)\t\n" +
            "5074\tPLUMBING HEATING\tServiceCategory.SERVICES)\t\n" +
            "5085\tINDUSTRIAL SUPPLY\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5094\tJEWELRY WATCHES\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5099\tDURABLE GOODS\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5111\tOFFICE SUPPLIES\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5122\tDRUGS\tServiceCategory.RETAIL)\t\n" +
            "5131\tFABRICS\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5137\tCOMMERCIAL CLOTHING\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5139\tCOMMERCIAL FOOTWEAR\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5169\tCHEMICALS\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5172\tPETROLEUM PRODUCTS\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5192\tBOOKS NEWSPAPERS\tServiceCategory.RETAIL)\t\n" +
            "5193\tFLORISTS SUPPLIES\tServiceCategory.RETAIL)\t\n" +
            "5198\tPAINTS VARNISHES\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5199\tNON-DURABLE GOODS\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "5200\tHOME SUPPLY WAREHOUSE\tServiceCategory.RETAIL)\t\n" +
            "5211\tLUMBER BUILDING\tServiceCategory.RETAIL)\t\n" +
            "5231\tGLASS PAINT WALLPAPER\tServiceCategory.RETAIL)\t\n" +
            "5251\tHARDWARE STORE\tServiceCategory.RETAIL)\t\n" +
            "5261\tLAWN GARDEN SUPPLIES\tServiceCategory.RETAIL)\t\n" +
            "5271\tMOBILE HOME DEALER\tServiceCategory.SERVICES)\t\n" +
            "5300\tWHOLESALE CLUB\tServiceCategory.RETAIL)\t\n" +
            "5309\tDUTY-FREE STORE\tServiceCategory.RETAIL)\t\n" +
            "5310\tDISCOUNT STORE\tServiceCategory.RETAIL)\t\n" +
            "5311\tDEPARTMENT STORE\tServiceCategory.RETAIL)\t\n" +
            "5331\tVARIETY STORE\tServiceCategory.RETAIL)\t\n" +
            "5399\tGENERAL MERCHANDISE\tServiceCategory.RETAIL)\t\n" +
            "5411\tGROCERY STORE\tServiceCategory.RETAIL)\t\n" +
            "5422\tFREEZER LOCKER MEAT\tServiceCategory.RETAIL)\t\n" +
            "5441\tCANDY CONFECTIONERY\tServiceCategory.RETAIL)\t\n" +
            "5451\tDAIRY PRODUCTS STORE\tServiceCategory.RETAIL)\t\n" +
            "5462\tBAKERY\tServiceCategory.RETAIL)\t\n" +
            "5499\tMISC FOOD STORE\tServiceCategory.RETAIL)\t\n" +
            "5511\tAUTO DEALER NEW USED\tServiceCategory.SERVICES)\t\n" +
            "5521\tAUTO DEALER USED\tServiceCategory.SERVICES)\t\n" +
            "5531\tAUTO HOME SUPPLY\tServiceCategory.RETAIL)\t\n" +
            "5532\tAUTOMOTIVE TIRE STORE\tServiceCategory.RETAIL)\t\n" +
            "5533\tAUTO PARTS ACCESSORY\tServiceCategory.RETAIL)\t\n" +
            "5541\tGAS STATION\tServiceCategory.OTHER)\t\n" +
            "5542\tAUTO FUEL DISPENSER\tServiceCategory.OTHER)\t\n" +
            "5551\tBOAT DEALER\tServiceCategory.RETAIL)\t\n" +
            "5561\tCAMPER TRAILER DEALER\tServiceCategory.SERVICES)\t\n" +
            "5571\tMOTORCYCLE DEALER\tServiceCategory.SERVICES)\t\n" +
            "5592\tMOTOR HOME DEALER\tServiceCategory.SERVICES)\t\n" +
            "5598\tSNOWMOBILE DEALER\tServiceCategory.SERVICES)\t\n" +
            "5599\tMISC VEHICLE DEALER\tServiceCategory.SERVICES)\t\n" +
            "5611\tMENS CLOTHING\tServiceCategory.RETAIL)\t\n" +
            "5621\tWOMENS CLOTHING\tServiceCategory.RETAIL)\t\n" +
            "5631\tWOMENS ACCESSORIES\tServiceCategory.RETAIL)\t\n" +
            "5641\tCHILDRENS CLOTHING\tServiceCategory.RETAIL)\t\n" +
            "5651\tFAMILY CLOTHING\tServiceCategory.RETAIL)\t\n" +
            "5655\tSPORTS CLOTHING\tServiceCategory.RETAIL)\t\n" +
            "5661\tSHOE STORE\tServiceCategory.RETAIL)\t\n" +
            "5681\tFURRIER AND FUR SHOP\tServiceCategory.RETAIL)\t\n" +
            "5691\tMENS WOMENS CLOTHNG\tServiceCategory.RETAIL)\t\n" +
            "5697\tTAILOR SEAMSTRESS\tServiceCategory.SERVICES)\t\n" +
            "5698\tWIG AND TOUPEE STORE\tServiceCategory.RETAIL)\t\n" +
            "5699\tMISC APPAREL STORE\tServiceCategory.RETAIL)\t\n" +
            "5712\tFURNITURE HOME STORE\tServiceCategory.RETAIL)\t\n" +
            "5713\tFLOOR COVERING STORE\tServiceCategory.RETAIL)\t\n" +
            "5714\tDRAPERY UPHOLSTERY\tServiceCategory.RETAIL)\t\n" +
            "5715\tWHOLESALE ALCOHOL\tServiceCategory.RETAIL)\t\n" +
            "5718\tFIREPLACE ACCESSORIES\tServiceCategory.RETAIL)\t\n" +
            "5719\tMISC HOME FURNISHINGS\tServiceCategory.RETAIL)\t\n" +
            "5722\tHOUSEHOLD APPLIANCES\tServiceCategory.RETAIL)\t\n" +
            "5732\tELECTRONICS STORE\tServiceCategory.RETAIL)\t\n" +
            "5733\tMUSIC STORE\tServiceCategory.RETAIL)\t\n" +
            "5734\tCOMPUTER STORE\tServiceCategory.RETAIL)\t\n" +
            "5735\tRECORD STORE\tServiceCategory.RETAIL)\t\n" +
            "5811\tRESTAURANT\tServiceCategory.RESTAURANT)\t\n" +
            "5812\tRESTAURANT\tServiceCategory.RESTAURANT)\t\n" +
            "5813\tRESTAURANT\tServiceCategory.RESTAURANT)\t\n" +
            "5814\tFAST FOOD RESTAURANT\tServiceCategory.RESTAURANT)\t\n" +
            "5815\t\tServiceCategory.RETAIL)\t\n" +
            "5912\tDRUG STORE PHARMACY\tServiceCategory.RETAIL)\t\n" +
            "5921\tLIQUOR STORE\tServiceCategory.RETAIL)\t\n" +
            "5931\tUSED MERCHANDISE\tServiceCategory.RETAIL)\t\n" +
            "5932\tANTIQUE SHOP\tServiceCategory.RETAIL)\t\n" +
            "5933\tPAWN SHOP\tServiceCategory.SERVICES)\t\n" +
            "5935\tWRECKING SALVAGE\tServiceCategory.SERVICES)\t\n" +
            "5937\tANTIQUE REPRODUCTION\tServiceCategory.RETAIL)\t\n" +
            "5940\tBICYCLE SHOP\tServiceCategory.RETAIL)\t\n" +
            "5941\tSPORTING GOODS STORE\tServiceCategory.RETAIL)\t\n" +
            "5942\tBOOK STORE\tServiceCategory.RETAIL)\t\n" +
            "5943\tOFFICE SUPPLY STORE\tServiceCategory.RETAIL)\t\n" +
            "5944\tJEWELRY WATCH SILVRWR\tServiceCategory.RETAIL)\t\n" +
            "5945\tHOBBY TOY GAME\tServiceCategory.RETAIL)\t\n" +
            "5946\tCAMERA PHOTO SUPPLY\tServiceCategory.RETAIL)\t\n" +
            "5947\tCARD SOUVENIR STORE\tServiceCategory.RETAIL)\t\n" +
            "5948\tLUGGAGE LEATHER GOODS\tServiceCategory.RETAIL)\t\n" +
            "5949\tSEWING FABRIC STORE\tServiceCategory.RETAIL)\t\n" +
            "5950\tGLASSWARE CRYSTAL\tServiceCategory.RETAIL)\t\n" +
            "5960\tDIRECT MKTG INSURANCE\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "5962\tDIRECT MKTG TRAVEL\tServiceCategory.PROHIBITED)\t\n" +
            "5963\tDOOR-TO-DOOR SALES\tServiceCategory.PROHIBITED)\t\n" +
            "5964\tCATALOG MERCHANDISE\tServiceCategory.SERVICES)\t\n" +
            "5965\tCATALOG SHOWROOM\tServiceCategory.RETAIL)\t\n" +
            "5966\tTELEMARKETING MDSE\tServiceCategory.PROHIBITED)\t\n" +
            "5967\tDIRECT MKTG INTERNET\tServiceCategory.PROHIBITED)\t\n" +
            "5968\tSUBSCRIPTIONS\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "5969\tDIRECT MKTG MISC\tServiceCategory.SERVICES)\t\n" +
            "5970\tARTIST SUPPLY CRAFT\tServiceCategory.RETAIL)\t\n" +
            "5971\tART DEALER GALLERY\tServiceCategory.RETAIL)\t\n" +
            "5972\tSTAMP COIN STORE\tServiceCategory.RETAIL)\t\n" +
            "5973\tRELIGIOUS GOODS STORE\tServiceCategory.RETAIL)\t\n" +
            "5975\tHEARING AIDS\tServiceCategory.SERVICES)\t\n" +
            "5976\tORTHOPEDIC PROSTHETIC\tServiceCategory.SERVICES)\t\n" +
            "5977\tCOSMETIC STORE\tServiceCategory.RETAIL)\t\n" +
            "5978\tTYPEWRITER STORE\tServiceCategory.RETAIL)\t\n" +
            "5983\tFUEL DEALER\tServiceCategory.SERVICES)\t\n" +
            "5992\tFLORIST\tServiceCategory.RETAIL)\t\n" +
            "5993\tCIGAR STORE STAND\tServiceCategory.RETAIL)\t\n" +
            "5994\tNEWS DEALER NEWSSTAND\tServiceCategory.RETAIL)\t\n" +
            "5995\tPET SHOP FOOD SUPPLY\tServiceCategory.RETAIL)\t\n" +
            "5996\tSWIMMING POOLS\tServiceCategory.RETAIL)\t\n" +
            "5997\tELECTRIC RAZOR STORE\tServiceCategory.RETAIL)\t\n" +
            "5998\tTENT AND AWNING STORE\tServiceCategory.RETAIL)\t\n" +
            "5999\tMISC SPECIALTY RETAIL\tServiceCategory.RETAIL)\t\n" +
            "6010\tFINANCIAL - TELLER\tServiceCategory.PROHIBITED)\t\n" +
            "6011\tFINANCIAL - ATM\tServiceCategory.PROHIBITED)\t\n" +
            "6012\tFINANCIAL - SERVICE\tServiceCategory.PROHIBITED)\t\n" +
            "6051\tNON FINANCIAL INST\tServiceCategory.PROHIBITED)\t\n" +
            "6211\tSECURITY BROKER\tServiceCategory.PROHIBITED)\t\n" +
            "6300\tINSURANCE SALES\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "7012\tTIMESHARE\tServiceCategory.PROHIBITED)\t\n" +
            "7032\tRECREATION CAMP\tServiceCategory.EDUCATION)\t\n" +
            "7210\tCLEANING GARMENT\tServiceCategory.SERVICES)\t\n" +
            "7211\tLAUNDRY SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7216\tDRY CLEANER\tServiceCategory.SERVICES)\t\n" +
            "7217\tCARPET CLEANING\tServiceCategory.SERVICES)\t\n" +
            "7221\tPHOTOGRAPHIC STUDIO\tServiceCategory.SERVICES)\t\n" +
            "7230\tBEAUTY BARBER SHOP\tServiceCategory.SERVICES)\t\n" +
            "7251\tSHOE REPAIR SHINE\tServiceCategory.SERVICES)\t\n" +
            "7261\tFUNERAL SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7273\tDATING SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7276\tTAX PREPARATION\tServiceCategory.SERVICES)\t\n" +
            "7277\tCOUNSELING SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7278\tBUYING SHOPPING CLUBS\tServiceCategory.SERVICES)\t\n" +
            "7296\tCLOTHING RENTAL\tServiceCategory.RETAIL)\t\n" +
            "7297\tMASSAGE PARLOR\tServiceCategory.SERVICES)\t\n" +
            "7298\tHEALTH BEAUTY SPA\tServiceCategory.SERVICES)\t\n" +
            "7299\tMISC PERSONAL SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7311\tADVERTISING SERVICE\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7321\tCREDIT REPORTING\tServiceCategory.SERVICES)\t\n" +
            "7322\tDEBT COLLECTION\tServiceCategory.PROHIBITED)\t\n" +
            "7333\tCOMMERCIAL PHOTO ART\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7338\tCOPY REPRODUCTION \tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7339\tSECRETARIAL SUPPORT\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7342\tEXTERMINATE DISINFECT\tServiceCategory.SERVICES)\t\n" +
            "7349\tCLEANING JANITORIAL\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7361\tEMPLOYMENT AGENCY\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7372\tCOMPUTER PROGRAMMING\tServiceCategory.SERVICES)\t\n" +
            "7375\tINFORMATION RETRIEVAL\tServiceCategory.SERVICES)\t\n" +
            "7379\tCOMPUTER MAINTENANCE\tServiceCategory.SERVICES)\t\n" +
            "7392\tMGMT CONSULTING PR\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7393\tSECURITY SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7394\tEQUIPMENT RENTAL\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7395\tPHOTO FINISHING\tServiceCategory.SERVICES)\t\n" +
            "7399\tBUSINESS SERVICE\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7512\tAUTOMOBILE RENTAL\tServiceCategory.T_AND_E)\t\n" +
            "7513\tTRUCK RENTAL\tServiceCategory.SERVICES)\t\n" +
            "7519\tMOTOR HOME RV RENTAL\tServiceCategory.SERVICES)\t\n" +
            "7523\tPARKING LOT GARAGE\tServiceCategory.SERVICES)\t\n" +
            "7531\tAUTO BODY REPAIR\tServiceCategory.SERVICES)\t\n" +
            "7534\tTIRE REPAIR\tServiceCategory.SERVICES)\t\n" +
            "7535\tAUTO PAINT SHOP\tServiceCategory.SERVICES)\t\n" +
            "7538\tAUTO SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7542\tCAR WASH\tServiceCategory.SERVICES)\t\n" +
            "7549\tTOWING SERVICE\tServiceCategory.SERVICES)\t\n" +
            "7622\tELECTRONICS REPAIR\tServiceCategory.RETAIL)\t\n" +
            "7623\tAC REFRIG REPAIR\tServiceCategory.SERVICES)\t\n" +
            "7629\tAPPLIANCE REPAIR\tServiceCategory.SERVICES)\t\n" +
            "7631\tWATCH JEWELRY REPAIR\tServiceCategory.RETAIL)\t\n" +
            "7641\tFURNITURE REPAIR\tServiceCategory.SERVICES)\t\n" +
            "7692\tWELDING SERVICE\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7699\tMISC REPAIR SHOP\tServiceCategory.SERVICES)\t\n" +
            "7829\tVIDEO PRODUCTION\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "7832\tMOVIE THEATER\tServiceCategory.SERVICES)\t\n" +
            "7841\tVIDEO RENTAL STORE\tServiceCategory.RETAIL)\t\n" +
            "7911\tDANCE HALL SCHOOL\tServiceCategory.EDUCATION)\t\n" +
            "7922\tTICKET AGENCY\tServiceCategory.T_AND_E)\t\n" +
            "7929\tMISC ENTERTAINER\tServiceCategory.T_AND_E)\t\n" +
            "7932\tBILLIARD POOL\tServiceCategory.T_AND_E)\t\n" +
            "7933\tBOWLING ALLEY\tServiceCategory.T_AND_E)\t\n" +
            "7941\tCOMMERCIAL SPORTS\tServiceCategory.T_AND_E)\t\n" +
            "7991\tTOURIST ATTRACTION\tServiceCategory.T_AND_E)\t\n" +
            "7992\tPUBLIC GOLF COURSE\tServiceCategory.T_AND_E)\t\n" +
            "7993\tVIDEO GAME SUPPLY\tServiceCategory.T_AND_E)\t\n" +
            "7994\tVIDEO GAME ARCADE\tServiceCategory.T_AND_E)\t\n" +
            "7997\tMEMBERSHIP CLUB\tServiceCategory.SERVICES)\t\n" +
            "7998\tAQUARIUM\tServiceCategory.T_AND_E)\t\n" +
            "8011\tDOCTOR PHYSICIAN\tServiceCategory.HEALTHCARE)\t\n" +
            "8021\tDENTIST ORTHODONTIST\tServiceCategory.HEALTHCARE)\t\n" +
            "8031\tOSTEOPATH\tServiceCategory.HEALTHCARE)\t\n" +
            "8041\tCHIROPRACTOR\tServiceCategory.HEALTHCARE)\t\n" +
            "8042\tOPTOMETRIST\tServiceCategory.HEALTHCARE)\t\n" +
            "8043\tOPTICIAN\tServiceCategory.HEALTHCARE)\t\n" +
            "8049\tPODIATRIST\tServiceCategory.HEALTHCARE)\t\n" +
            "8050\tNURSING PERSONAL CARE\tServiceCategory.HEALTHCARE)\t\n" +
            "8062\tHOSPITAL\tServiceCategory.HEALTHCARE)\t\n" +
            "8071\tMEDICAL DENTAL LAB\tServiceCategory.HEALTHCARE)\t\n" +
            "8099\tMEDICAL SERVICE\tServiceCategory.HEALTHCARE)\t\n" +
            "8111\tLEGAL SERVICE\tServiceCategory.SERVICES)\t\n" +
            "8211\tSCHOOL\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "8220\tCOLLEGE UNIVERSITY\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "8241\tCORRESPONDENCE SCHOOL\tServiceCategory.EDUCATION)\t\n" +
            "8244\tSECRETARIAL SCHOOL\tServiceCategory.EDUCATION)\t\n" +
            "8249\tTRADE VOCATION SCHOOL\tServiceCategory.EDUCATION)\t\n" +
            "8299\tEDUCATIONAL SERVICE\tServiceCategory.EDUCATION)\t\n" +
            "8351\tCHILD CARE SERVICE\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "8398\tCHARITABLE ORG\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "8641\tCIVIC SOCIAL ASSOC\tServiceCategory.SERVICES)\t\n" +
            "8651\tPOLITICAL ORG\tServiceCategory.OTHER)\t\n" +
            "8661\tRELIGIOUS ORG\tServiceCategory.OTHER)\t\n" +
            "8675\tAUTOMOBILE ASSOC\tServiceCategory.SERVICES)\t\n" +
            "8699\tMEMBERSHIP ORGS\tServiceCategory.SERVICES)\t\n" +
            "8734\tTESTING LABORATORY\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "8911\tARCHITECT ENGINEER\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "8931\tACCOUNTING AUDITING\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "8999\tPROFESSIONAL SERVICE\tServiceCategory.B2B_WHOLESALE)\t\n" +
            "9211\tCOURT COSTS\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "9211\tCOURT COSTS\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "9222\tFINE\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "9222\tFINE\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "9223\tBAIL AND BOND PAYMENT\tServiceCategory.GOVERNMENT)\t\n" +
            "9223\tBAIL AND BOND PAYMENT\tServiceCategory.GOVERNMENT)\t\n" +
            "9311\tTAX PAYMENT\tServiceCategory.GOVERNMENT)\t\n" +
            "9311\tTAX PAYMENT\tServiceCategory.GOVERNMENT)\t\n" +
            "9399\tGOVERNMENT SERVICE\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "9399\tGOVERNMENT SERVICE\tServiceCategory.EMERGING_MARKETS)\t\n" +
            "9402\tPOSTAL SERVICE\tServiceCategory.PROHIBITED)\t\n" +
            "9402\tPOSTAL SERVICE\tServiceCategory.PROHIBITED)\t";

    String merchantCategoryOld = "0\tUNKNOWN\tServiceCategory.OTHER)\n" +
            "1520\tGENERAL CONTRACTOR\tServiceCategory.SERVICES)\n" +
            "1711\tHEATING PLUMBING AC\tServiceCategory.SERVICES)\n" +
            "1731\tELECTRICAL CONTRACTOR\tServiceCategory.SERVICES)\n" +
            "1740\tMASONRY TILE INSULATE\tServiceCategory.SERVICES)\n" +
            "1750\tCARPENTRY CONTRACTOR\tServiceCategory.SERVICES)\n" +
            "1761\tROOFING SIDING\tServiceCategory.SERVICES)\n" +
            "1771\tCONCRETE WORK\tServiceCategory.SERVICES)\n" +
            "1799\tMISC CONTRACTOR\tServiceCategory.B2B_WHOLESALE)\n" +
            "2741\tPUBLISHING PRINTING\tServiceCategory.SERVICES)\n" +
            "2791\tTYPESETTING SERVICE\tServiceCategory.B2B_WHOLESALE)\n" +
            "2842\tMISC CLEANING PRODUCT\tServiceCategory.SERVICES)\n" +
            "4011\tFREIGHT RAILROAD\tServiceCategory.PROHIBITED)\n" +
            "4111\tLOCAL TRANSPORTATION\tServiceCategory.PROHIBITED)\n" +
            "4112\tPASSENGER RAILWAY\tServiceCategory.PROHIBITED)\n" +
            "4119\tAMBULANCE SERVICE\tServiceCategory.SERVICES)\n" +
            "4121\tTAXICAB LIMOUSINE\tServiceCategory.OTHER)\n" +
            "4131\tBUS LINE\tServiceCategory.OTHER)\n" +
            "4214\tFREIGHT MOVING\tServiceCategory.SERVICES)\n" +
            "4215\tCOURIER SERVICE\tServiceCategory.B2B_WHOLESALE)\n" +
            "4225\tWAREHOUSING STORAGE\tServiceCategory.SERVICES)\n" +
            "4411\tCRUISE LINE\tServiceCategory.PROHIBITED)\n" +
            "4457\tBOAT RENTAL\tServiceCategory.SERVICES)\n" +
            "4468\tMARINE SERVICE SUPPLY\tServiceCategory.SERVICES)\n" +
            "4511\tAIRLINE AIR CARRIER\tServiceCategory.PROHIBITED)\n" +
            "4582\tAIRPORT TERMINAL\tServiceCategory.OTHER)\n" +
            "4784\tTOLL BRIDGE FEE\tServiceCategory.OTHER)\n" +
            "4789\tMISC TRANSPORTATION\tServiceCategory.OTHER)\n" +
            "4812\tTELECOM EQUIPMENT\tServiceCategory.OTHER)\n" +
            "4814\tTELECOM SERVICE\tServiceCategory.PROHIBITED)\n" +
            "4815\tMONTHLY TELEPHONE\tServiceCategory.PROHIBITED)\n" +
            "4816\tCOMPUTER NETWORK INFO\tServiceCategory.OTHER)\n" +
            "4821\tTELEGRAPH SERVICE\tServiceCategory.SERVICES)\n" +
            "4829\tWIRE XFER MONEY ORDER\tServiceCategory.PROHIBITED)\n" +
            "4899\tCABLE PAY TV\tServiceCategory.OTHER)\n" +
            "4900\tPUBLIC UTILITY\tServiceCategory.SERVICES)\n" +
            "5013\tAUTO SUPPLIES PARTS\tServiceCategory.RETAIL)\n" +
            "5021\tOFFICE FURNITURE\tServiceCategory.RETAIL)\n" +
            "5039\tCONSTRUCTION MATERIAL\tServiceCategory.B2B_WHOLESALE)\n" +
            "5044\tOFFICE EQUIPMENT\tServiceCategory.RETAIL)\n" +
            "5045\tCOMPUTERS EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\n" +
            "5046\tCOMMERICAL EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\n" +
            "5047\tMEDICAL EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\n" +
            "5051\tMETAL SERVICE CENTER\tServiceCategory.B2B_WHOLESALE)\n" +
            "5065\tELECTRICAL EQUIPMENT\tServiceCategory.B2B_WHOLESALE)\n" +
            "5072\tHARDWARE EQUIPMENT\tServiceCategory.RETAIL)\n" +
            "5074\tPLUMBING HEATING\tServiceCategory.SERVICES)\n" +
            "5085\tINDUSTRIAL SUPPLY\tServiceCategory.B2B_WHOLESALE)\n" +
            "5094\tJEWELRY WATCHES\tServiceCategory.B2B_WHOLESALE)\n" +
            "5099\tDURABLE GOODS\tServiceCategory.B2B_WHOLESALE)\n" +
            "5111\tOFFICE SUPPLIES\tServiceCategory.B2B_WHOLESALE)\n" +
            "5122\tDRUGS\tServiceCategory.B2B_WHOLESALE)\n" +
            "5131\tFABRICS\tServiceCategory.B2B_WHOLESALE)\n" +
            "5137\tCOMMERCIAL CLOTHING\tServiceCategory.B2B_WHOLESALE)\n" +
            "5139\tCOMMERCIAL FOOTWEAR\tServiceCategory.B2B_WHOLESALE)\n" +
            "5169\tCHEMICALS\tServiceCategory.B2B_WHOLESALE)\n" +
            "5172\tPETROLEUM PRODUCTS\tServiceCategory.PROHIBITED)\n" +
            "5192\tBOOKS NEWSPAPERS\tServiceCategory.RETAIL)\n" +
            "5193\tFLORISTS SUPPLIES\tServiceCategory.B2B_WHOLESALE)\n" +
            "5198\tPAINTS VARNISHES\tServiceCategory.B2B_WHOLESALE)\n" +
            "5199\tNON-DURABLE GOODS\tServiceCategory.B2B_WHOLESALE)\n" +
            "5200\tHOME SUPPLY WAREHOUSE\tServiceCategory.RETAIL)\n" +
            "5211\tLUMBER BUILDING\tServiceCategory.RETAIL)\n" +
            "5231\tGLASS PAINT WALLPAPER\tServiceCategory.RETAIL)\n" +
            "5251\tHARDWARE STORE\tServiceCategory.RETAIL)\n" +
            "5261\tLAWN GARDEN SUPPLIES\tServiceCategory.RETAIL)\n" +
            "5271\tMOBILE HOME DEALER\tServiceCategory.SERVICES)\n" +
            "5300\tWHOLESALE CLUB\tServiceCategory.SERVICES)\n" +
            "5309\tDUTY-FREE STORE\tServiceCategory.RETAIL)\n" +
            "5310\tDISCOUNT STORE\tServiceCategory.RETAIL)\n" +
            "5311\tDEPARTMENT STORE\tServiceCategory.RETAIL)\n" +
            "5331\tVARIETY STORE\tServiceCategory.RETAIL)\n" +
            "5399\tGENERAL MERCHANDISE\tServiceCategory.RETAIL)\n" +
            "5411\tGROCERY STORE\tServiceCategory.RETAIL)\n" +
            "5422\tFREEZER LOCKER MEAT\tServiceCategory.RETAIL)\n" +
            "5441\tCANDY CONFECTIONERY\tServiceCategory.RETAIL)\n" +
            "5451\tDAIRY PRODUCTS STORE\tServiceCategory.RETAIL)\n" +
            "5462\tBAKERY\tServiceCategory.RETAIL)\n" +
            "5499\tMISC FOOD STORE\tServiceCategory.RETAIL)\n" +
            "5511\tAUTO DEALER NEW USED\tServiceCategory.SERVICES)\n" +
            "5521\tAUTO DEALER USED\tServiceCategory.SERVICES)\n" +
            "5531\tAUTO HOME SUPPLY\tServiceCategory.RETAIL)\n" +
            "5532\tAUTOMOTIVE TIRE STORE\tServiceCategory.RETAIL)\n" +
            "5533\tAUTO PARTS ACCESSORY\tServiceCategory.RETAIL)\n" +
            "5541\tGAS STATION\tServiceCategory.OTHER)\n" +
            "5542\tAUTO FUEL DISPENSER\tServiceCategory.OTHER)\n" +
            "5551\tBOAT DEALER\tServiceCategory.RETAIL)\n" +
            "5561\tCAMPER TRAILER DEALER\tServiceCategory.SERVICES)\n" +
            "5571\tMOTORCYCLE DEALER\tServiceCategory.SERVICES)\n" +
            "5592\tMOTOR HOME DEALER\tServiceCategory.SERVICES)\n" +
            "5598\tSNOWMOBILE DEALER\tServiceCategory.SERVICES)\n" +
            "5599\tMISC VEHICLE DEALER\tServiceCategory.SERVICES)\n" +
            "5611\tMENS CLOTHING\tServiceCategory.RETAIL)\n" +
            "5621\tWOMENS CLOTHING\tServiceCategory.RETAIL)\n" +
            "5631\tWOMENS ACCESSORIES\tServiceCategory.RETAIL)\n" +
            "5641\tCHILDRENS CLOTHING\tServiceCategory.RETAIL)\n" +
            "5651\tFAMILY CLOTHING\tServiceCategory.RETAIL)\n" +
            "5655\tSPORTS CLOTHING\tServiceCategory.RETAIL)\n" +
            "5661\tSHOE STORE\tServiceCategory.RETAIL)\n" +
            "5681\tFURRIER AND FUR SHOP\tServiceCategory.RETAIL)\n" +
            "5691\tMENS WOMENS CLOTHNG\tServiceCategory.RETAIL)\n" +
            "5697\tTAILOR SEAMSTRESS\tServiceCategory.SERVICES)\n" +
            "5698\tWIG AND TOUPEE STORE\tServiceCategory.RETAIL)\n" +
            "5699\tMISC APPAREL STORE\tServiceCategory.RETAIL)\n" +
            "5712\tFURNITURE HOME STORE\tServiceCategory.RETAIL)\n" +
            "5713\tFLOOR COVERING STORE\tServiceCategory.RETAIL)\n" +
            "5714\tDRAPERY UPHOLSTERY\tServiceCategory.RETAIL)\n" +
            "5715\tWHOLESALE ALCOHOL\tServiceCategory.RETAIL)\n" +
            "5718\tFIREPLACE ACCESSORIES\tServiceCategory.RETAIL)\n" +
            "5719\tMISC HOME FURNISHINGS\tServiceCategory.RETAIL)\n" +
            "5722\tHOUSEHOLD APPLIANCES\tServiceCategory.RETAIL)\n" +
            "5732\tELECTRONICS STORE\tServiceCategory.RETAIL)\n" +
            "5733\tMUSIC STORE\tServiceCategory.RETAIL)\n" +
            "5734\tCOMPUTER STORE\tServiceCategory.RETAIL)\n" +
            "5735\tRECORD STORE\tServiceCategory.RETAIL)\n" +
            "5811\tCATERER\tServiceCategory.CATER_DRINK)\n" +
            "5812\tRESTAURANT\tServiceCategory.RESTAURANT)\n" +
            "5813\tBAR NIGHTCLUB\tServiceCategory.CATER_DRINK)\n" +
            "5814\tFAST FOOD RESTAURANT\tServiceCategory.RESTAURANT)\n" +
            "5912\tDRUG STORE PHARMACY\tServiceCategory.RETAIL)\n" +
            "5921\tLIQUOR STORE\tServiceCategory.RETAIL)\n" +
            "5931\tUSED MERCHANDISE\tServiceCategory.RETAIL)\n" +
            "5932\tANTIQUE SHOP\tServiceCategory.RETAIL)\n" +
            "5933\tPAWN SHOP\tServiceCategory.SERVICES)\n" +
            "5935\tWRECKING SALVAGE\tServiceCategory.SERVICES)\n" +
            "5937\tANTIQUE REPRODUCTION\tServiceCategory.RETAIL)\n" +
            "5940\tBICYCLE SHOP\tServiceCategory.RETAIL)\n" +
            "5941\tSPORTING GOODS STORE\tServiceCategory.RETAIL)\n" +
            "5942\tBOOK STORE\tServiceCategory.RETAIL)\n" +
            "5943\tOFFICE SUPPLY STORE\tServiceCategory.RETAIL)\n" +
            "5944\tJEWELRY WATCH SILVRWR\tServiceCategory.RETAIL)\n" +
            "5945\tHOBBY TOY GAME\tServiceCategory.RETAIL)\n" +
            "5946\tCAMERA PHOTO SUPPLY\tServiceCategory.RETAIL)\n" +
            "5947\tCARD SOUVENIR STORE\tServiceCategory.RETAIL)\n" +
            "5948\tLUGGAGE LEATHER GOODS\tServiceCategory.RETAIL)\n" +
            "5949\tSEWING FABRIC STORE\tServiceCategory.RETAIL)\n" +
            "5950\tGLASSWARE CRYSTAL\tServiceCategory.RETAIL)\n" +
            "5960\tDIRECT MKTG INSURANCE\tServiceCategory.PROHIBITED)\n" +
            "5962\tDIRECT MKTG TRAVEL\tServiceCategory.PROHIBITED)\n" +
            "5963\tDOOR-TO-DOOR SALES\tServiceCategory.PROHIBITED)\n" +
            "5964\tCATALOG MERCHANDISE\tServiceCategory.INTERNET)\n" +
            "5965\tCATALOG SHOWROOM\tServiceCategory.RETAIL)\n" +
            "5966\tTELEMARKETING MDSE\tServiceCategory.PROHIBITED)\n" +
            "5967\tDIRECT MKTG INTERNET\tServiceCategory.PROHIBITED)\n" +
            "5968\tSUBSCRIPTIONS\tServiceCategory.INTERNET)\n" +
            "5969\tDIRECT MKTG MISC\tServiceCategory.INTERNET)\n" +
            "5970\tARTIST SUPPLY CRAFT\tServiceCategory.RETAIL)\n" +
            "5971\tART DEALER GALLERY\tServiceCategory.RETAIL)\n" +
            "5972\tSTAMP COIN STORE\tServiceCategory.RETAIL)\n" +
            "5973\tRELIGIOUS GOODS STORE\tServiceCategory.RETAIL)\n" +
            "5975\tHEARING AIDS\tServiceCategory.SERVICES)\n" +
            "5976\tORTHOPEDIC PROSTHETIC\tServiceCategory.SERVICES)\n" +
            "5977\tCOSMETIC STORE\tServiceCategory.RETAIL)\n" +
            "5978\tTYPEWRITER STORE\tServiceCategory.RETAIL)\n" +
            "5983\tFUEL DEALER\tServiceCategory.SERVICES)\n" +
            "5992\tFLORIST\tServiceCategory.RETAIL)\n" +
            "5993\tCIGAR STORE STAND\tServiceCategory.RETAIL)\n" +
            "5994\tNEWS DEALER NEWSSTAND\tServiceCategory.RETAIL)\n" +
            "5995\tPET SHOP FOOD SUPPLY\tServiceCategory.RETAIL)\n" +
            "5996\tSWIMMING POOLS\tServiceCategory.RETAIL)\n" +
            "5997\tELECTRIC RAZOR STORE\tServiceCategory.RETAIL)\n" +
            "5998\tTENT AND AWNING STORE\tServiceCategory.RETAIL)\n" +
            "5999\tMISC SPECIALTY RETAIL\tServiceCategory.RETAIL)\n" +
            "6010\tFINANCIAL - TELLER\tServiceCategory.PROHIBITED)\n" +
            "6011\tFINANCIAL - ATM\tServiceCategory.PROHIBITED)\n" +
            "6012\tFINANCIAL - SERVICE\tServiceCategory.PROHIBITED)\n" +
            "6051\tNON FINANCIAL INST\tServiceCategory.PROHIBITED)\n" +
            "6211\tSECURITY BROKER\tServiceCategory.PROHIBITED)\n" +
            "6300\tINSURANCE SALES\tServiceCategory.B2B_WHOLESALE)\n" +
            "7012\tTIMESHARE\tServiceCategory.PROHIBITED)\n" +
            "7032\tRECREATION CAMP\tServiceCategory.EDUCATION)\n" +
            "7210\tCLEANING GARMENT\tServiceCategory.SERVICES)\n" +
            "7211\tLAUNDRY SERVICE\tServiceCategory.SERVICES)\n" +
            "7216\tDRY CLEANER\tServiceCategory.SERVICES)\n" +
            "7217\tCARPET CLEANING\tServiceCategory.SERVICES)\n" +
            "7221\tPHOTOGRAPHIC STUDIO\tServiceCategory.SERVICES)\n" +
            "7230\tBEAUTY BARBER SHOP\tServiceCategory.SERVICES)\n" +
            "7251\tSHOE REPAIR SHINE\tServiceCategory.SERVICES)\n" +
            "7261\tFUNERAL SERVICE\tServiceCategory.SERVICES)\n" +
            "7273\tDATING SERVICE\tServiceCategory.PROHIBITED)\n" +
            "7276\tTAX PREPARATION\tServiceCategory.SERVICES)\n" +
            "7277\tCOUNSELING SERVICE\tServiceCategory.SERVICES)\n" +
            "7278\tBUYING SHOPPING CLUBS\tServiceCategory.SERVICES)\n" +
            "7296\tCLOTHING RENTAL\tServiceCategory.RETAIL)\n" +
            "7297\tMASSAGE PARLOR\tServiceCategory.PROHIBITED)\n" +
            "7298\tHEALTH BEAUTY SPA\tServiceCategory.SERVICES)\n" +
            "7299\tMISC PERSONAL SERVICE\tServiceCategory.SERVICES)\n" +
            "7311\tADVERTISING SERVICE\tServiceCategory.B2B_WHOLESALE)\n" +
            "7321\tCREDIT REPORTING\tServiceCategory.SERVICES)\n" +
            "7322\tDEBT COLLECTION\tServiceCategory.PROHIBITED)\n" +
            "7333\tCOMMERCIAL PHOTO ART\tServiceCategory.B2B_WHOLESALE)\n" +
            "7338\tCOPY REPRODUCTION \tServiceCategory.B2B_WHOLESALE)\n" +
            "7339\tSECRETARIAL SUPPORT\tServiceCategory.B2B_WHOLESALE)\n" +
            "7342\tEXTERMINATE DISINFECT\tServiceCategory.SERVICES)\n" +
            "7349\tCLEANING JANITORIAL\tServiceCategory.B2B_WHOLESALE)\n" +
            "7361\tEMPLOYMENT AGENCY\tServiceCategory.B2B_WHOLESALE)\n" +
            "7372\tCOMPUTER PROGRAMMING\tServiceCategory.SERVICES)\n" +
            "7375\tINFORMATION RETRIEVAL\tServiceCategory.SERVICES)\n" +
            "7379\tCOMPUTER MAINTENANCE\tServiceCategory.SERVICES)\n" +
            "7392\tMGMT CONSULTING PR\tServiceCategory.B2B_WHOLESALE)\n" +
            "7393\tSECURITY SERVICE\tServiceCategory.SERVICES)\n" +
            "7394\tEQUIPMENT RENTAL\tServiceCategory.B2B_WHOLESALE)\n" +
            "7395\tPHOTO FINISHING\tServiceCategory.SERVICES)\n" +
            "7399\tBUSINESS SERVICE\tServiceCategory.B2B_WHOLESALE)\n" +
            "742\tVETERINARY SERVICE\tServiceCategory.SERVICES)\n" +
            "743\tWINE PRODUCER\tServiceCategory.SERVICES)\n" +
            "744\tCHAMPAGNE PRODUCER\tServiceCategory.SERVICES)\n" +
            "7512\tAUTOMOBILE RENTAL\tServiceCategory.PROHIBITED)\n" +
            "7513\tTRUCK RENTAL\tServiceCategory.PROHIBITED)\n" +
            "7519\tMOTOR HOME RV RENTAL\tServiceCategory.PROHIBITED)\n" +
            "7523\tPARKING LOT GARAGE\tServiceCategory.SERVICES)\n" +
            "7531\tAUTO BODY REPAIR\tServiceCategory.SERVICES)\n" +
            "7534\tTIRE REPAIR\tServiceCategory.SERVICES)\n" +
            "7535\tAUTO PAINT SHOP\tServiceCategory.SERVICES)\n" +
            "7538\tAUTO SERVICE\tServiceCategory.SERVICES)\n" +
            "7542\tCAR WASH\tServiceCategory.SERVICES)\n" +
            "7549\tTOWING SERVICE\tServiceCategory.SERVICES)\n" +
            "7622\tELECTRONICS REPAIR\tServiceCategory.B2B_WHOLESALE)\n" +
            "7623\tAC REFRIG REPAIR\tServiceCategory.SERVICES)\n" +
            "7629\tAPPLIANCE REPAIR\tServiceCategory.SERVICES)\n" +
            "763\tAGRICULTURAL CO-OP\tServiceCategory.SERVICES)\n" +
            "7631\tWATCH JEWELRY REPAIR\tServiceCategory.RETAIL)\n" +
            "7641\tFURNITURE REPAIR\tServiceCategory.SERVICES)\n" +
            "7692\tWELDING SERVICE\tServiceCategory.B2B_WHOLESALE)\n" +
            "7699\tMISC REPAIR SHOP\tServiceCategory.SERVICES)\n" +
            "780\tLANDSCAPE HORTICULTURE \tServiceCategory.B2B_WHOLESALE)\n" +
            "7829\tVIDEO PRODUCTION\tServiceCategory.B2B_WHOLESALE)\n" +
            "7832\tMOVIE THEATER\tServiceCategory.SERVICES)\n" +
            "7841\tVIDEO RENTAL STORE\tServiceCategory.RETAIL)\n" +
            "7911\tDANCE HALL SCHOOL\tServiceCategory.EDUCATION)\n" +
            "7922\tTICKET AGENCY\tServiceCategory.SERVICES)\n" +
            "7929\tMISC ENTERTAINER\tServiceCategory.SERVICES)\n" +
            "7932\tBILLIARD POOL\tServiceCategory.SERVICES)\n" +
            "7933\tBOWLING ALLEY\tServiceCategory.SERVICES)\n" +
            "7941\tCOMMERCIAL SPORTS\tServiceCategory.B2B_WHOLESALE)\n" +
            "7991\tTOURIST ATTRACTION\tServiceCategory.SERVICES)\n" +
            "7992\tPUBLIC GOLF COURSE\tServiceCategory.SERVICES)\n" +
            "7993\tVIDEO GAME SUPPLY\tServiceCategory.SERVICES)\n" +
            "7994\tVIDEO GAME ARCADE\tServiceCategory.SERVICES)\n" +
            "7997\tMEMBERSHIP CLUB\tServiceCategory.SERVICES)\n" +
            "7998\tAQUARIUM\tServiceCategory.SERVICES)\n" +
            "8011\tDOCTOR PHYSICIAN\tServiceCategory.HEALTHCARE_PRACTITONER)\n" +
            "8021\tDENTIST ORTHODONTIST\tServiceCategory.HEALTHCARE_PRACTITONER)\n" +
            "8031\tOSTEOPATH\tServiceCategory.HEALTHCARE)\n" +
            "8041\tCHIROPRACTOR\tServiceCategory.HEALTHCARE)\n" +
            "8042\tOPTOMETRIST\tServiceCategory.HEALTHCARE)\n" +
            "8043\tOPTICIAN\tServiceCategory.HEALTHCARE)\n" +
            "8049\tPODIATRIST\tServiceCategory.HEALTHCARE)\n" +
            "8050\tNURSING PERSONAL CARE\tServiceCategory.HEALTHCARE)\n" +
            "8062\tHOSPITAL\tServiceCategory.HEALTHCARE)\n" +
            "8071\tMEDICAL DENTAL LAB\tServiceCategory.HEALTHCARE)\n" +
            "8099\tMEDICAL SERVICE\tServiceCategory.HEALTHCARE)\n" +
            "8111\tLEGAL SERVICE\tServiceCategory.SERVICES)\n" +
            "8211\tSCHOOL\tServiceCategory.EDUCATION)\n" +
            "8220\tCOLLEGE UNIVERSITY\tServiceCategory.EDUCATION)\n" +
            "8241\tCORRESPONDENCE SCHOOL\tServiceCategory.EDUCATION)\n" +
            "8244\tSECRETARIAL SCHOOL\tServiceCategory.EDUCATION)\n" +
            "8249\tTRADE VOCATION SCHOOL\tServiceCategory.EDUCATION)\n" +
            "8299\tEDUCATIONAL SERVICE\tServiceCategory.EDUCATION)\n" +
            "8351\tCHILD CARE SERVICE\tServiceCategory.EDUCATION)\n" +
            "8398\tCHARITABLE ORG\tServiceCategory.OTHER)\n" +
            "8641\tCIVIC SOCIAL ASSOC\tServiceCategory.SERVICES)\n" +
            "8651\tPOLITICAL ORG\tServiceCategory.SERVICES)\n" +
            "8661\tRELIGIOUS ORG\tServiceCategory.OTHER)\n" +
            "8675\tAUTOMOBILE ASSOC\tServiceCategory.SERVICES)\n" +
            "8699\tMEMBERSHIP ORGS\tServiceCategory.SERVICES)\n" +
            "8734\tTESTING LABORATORY\tServiceCategory.B2B_WHOLESALE)\n" +
            "8911\tARCHITECT ENGINEER\tServiceCategory.B2B_WHOLESALE)\n" +
            "8931\tACCOUNTING AUDITING\tServiceCategory.B2B_WHOLESALE)\n" +
            "8999\tPROFESSIONAL SERVICE\tServiceCategory.B2B_WHOLESALE)\n" +
            "9211\tCOURT COSTS\tServiceCategory.GOVERNMENT)\n" +
            "9222\tFINE\tServiceCategory.GOVERNMENT)\n" +
            "9223\tBAIL AND BOND PAYMENT\tServiceCategory.GOVERNMENT)\n" +
            "9311\tTAX PAYMENT\tServiceCategory.GOVERNMENT)\n" +
            "9399\tGOVERNMENT SERVICE\tServiceCategory.GOVERNMENT)\n" +
            "9402\tPOSTAL SERVICE\tServiceCategory.PROHIBITED)";

}

