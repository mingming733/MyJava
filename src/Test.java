import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Test {
    static String act72InfoTable = "`mythic-crane-708.s_lanai.chase_dfr_transaction_fee_information_detail`";
    static String act72detailTable = "`mythic-crane-708.s_lanai.chase_dfr_transaction_fee_detail`";
    static String headerTable = "`mythic-crane-708.s_lanai.chase_dfr_header`";
    public static void main(String[] args) {
        System.out.println(getQuery());
    }

    public static String getQuery() {
        // get total assessment_fee in app level from FIN11
        return "SELECT " +
                "  i.entityNumber as transaction_division_id, " +
                "  SUM(settlementAmount) AS monthly_tpv, " +
                "  SUM(CAST(totalFee AS NUMERIC)) AS assessment_fee, " +
                "  EXTRACT(month FROM current_date()) - 1 AS from_date, " +
                "  EXTRACT(month FROM current_date()) - 1 AS to_date " +
                "FROM " + act72InfoTable + " AS i, " +
                act72detailTable + " AS d, " +
                headerTable + " AS h " +
                "WHERE " +
                "  i.reportHeaderId = h.id " +
                "  AND d.informationReportRowId = i.reportRowId " +
                "  AND d.category = 'IA' " +
                "  AND d.subCategory = 'AS' " +
                "  AND EXTRACT(month FROM h.reportDateFrom) = EXTRACT(month FROM current_date()) - 1 " +
                "GROUP BY " +
                "  i.entityNumber";
    }
}
