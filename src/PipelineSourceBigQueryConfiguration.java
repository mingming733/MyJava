public class PipelineSourceBigQueryConfiguration {

    private final String projectId;
    private final String datasetId;

    public PipelineSourceBigQueryConfiguration() {
        super();
        this.projectId = "mythic-crane-708";
        this.datasetId = "mingm";
    }

    public String getMappedTableName(final String tableName) {
        return "`" + this.projectId + "." + this.datasetId + "." + tableName + "`";
//        return tableName;
    }
}