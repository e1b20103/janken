package oit.is.z1141.kaizi.janken.model;
public class User {
  int id;
  String name;

  // Thymeleafでフィールドを扱うためにはgetter/setterが必ず必要
  // vscodeのソースコード右クリック->ソースアクションでsetter/getterを簡単に追加できる
  public String getUserName() {
    return name;
  }

  public void setUserName(String name) {
    this.name = name;
  }

  // public String getChamberName() {
  //   return chamberName;
  // }

  // public void setChamberName(String chamberName) {
  //   this.chamberName = chamberName;
  // }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
