package com.example.core.model;

import java.io.Serializable;

    public class InnerMessage implements Serializable {

        private String[] arguments;
        private byte[] fileContent;


        public String[] getArguments() {
            return arguments;
        }

        public void setArguments(String[] arguments) {
            this.arguments = arguments;
        }


        public void setFileContent(byte[] fileContent) {
            this.fileContent = fileContent;
        }

        public byte[] getFileContent() {
            return fileContent;
        }
    }
