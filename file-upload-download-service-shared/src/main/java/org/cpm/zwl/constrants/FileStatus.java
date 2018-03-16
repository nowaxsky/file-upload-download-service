package org.cpm.zwl.constrants;

public enum FileStatus {

  ,;
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
