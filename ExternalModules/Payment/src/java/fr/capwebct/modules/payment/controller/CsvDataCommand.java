package fr.capwebct.modules.payment.controller;

/**
 * Command object for dealing with CSV data import/export.
 * 
 * @author Benoit Orihuela (bor@zenexity.fr)
 */
public class CsvDataCommand {

        private byte[] data;
        private byte[] detailsData;
        
        private String dataType;
        private String externalApplicationId;
        private String externalApplicationBroker;
        
        public byte[] getData() {
            return data;
        }
        
        public void setData(byte[] data) {
            this.data = data;
        }

        public byte[] getDetailsData() {
            return detailsData;
        }

        public void setDetailsData(byte[] detailsData) {
            this.detailsData = detailsData;
        }

        public String getDataType() {
            return dataType;
        }

        public void setDataType(String dataType) {
            this.dataType = dataType;
        }

        public String getExternalApplicationId() {
            return externalApplicationId;
        }

        public void setExternalApplicationId(String externalApplicationLabel) {
            this.externalApplicationId = externalApplicationLabel;
        }

        public String getExternalApplicationBroker() {
            return externalApplicationBroker;
        }

        public void setExternalApplicationBroker(String broker) {
            this.externalApplicationBroker = broker;
        }
}
