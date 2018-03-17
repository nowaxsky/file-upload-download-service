package org.cpm.zwl.constrants;

public enum FileStatus {

  STATUS_A("STATUS_A"), // status A
  STATUS_B("STATUS_B"), // status B
  ;
  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  private FileStatus(String value) {
    this.value = value;
  }
}
