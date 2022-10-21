package oit.is.z1141.kaizi.janken.model;

public class Match {
  int id;
  int user1;
  int user2;
  String user1Hand;
  String user2Hand;
  /**
   * 引数ありコンストラクタを作る際，Beanであれば必ずデフォルトコンストラクタを明示的に追加すること
   */
  public Match() {

  }

  public Match(int user1, int user2,String user1Hand, String user2Hand) {
    this.user1 = user1;
    this.user2 = user2;
  }

  public String getUser1Hand() {
    return user1Hand;
  }

  public void setUser1Hand(String user1Hand) {
    this.user1Hand = user1Hand;
  }

  public String getUser2Hand() {
    return user2Hand;
  }

  public void setUser2Hand(String user2Hand) {
    this.user2Hand = user2Hand;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

}
