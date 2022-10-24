
package oit.is.z1141.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.bind.annotation.RequestMapping;
//import oit.is.z1141.kaizi.janken.model.Janken;
import oit.is.z1141.kaizi.janken.model.Match;
import oit.is.z1141.kaizi.janken.model.MatchMapper;
import oit.is.z1141.kaizi.janken.model.User;
import oit.is.z1141.kaizi.janken.model.UserMapper;
import oit.is.z1141.kaizi.janken.model.Entry;

/**
 * Sample21Controller
 * index
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
@RequestMapping("/janken")
public class JankenController {
  @Autowired
  private Entry room;
   UserMapper userMapper;
   //MatchMapper matchMapper;
  //// 消さない
  // @GetMapping("janken")
  // public String janken() {
  // return "janken.html";
  // }

  /**
   * パスパラメータ2つをGETで受け付ける 1つ目の変数をparam1という名前で，2つ目の変数をparam2という名前で受け取る
   * GETで受け取った2つの変数とsample22()の引数の名前が同じなため， 引数の前に @PathVariable と付けるだけで，パスパラメータの値を
   * javaで処理できるようになる ModelMapはthymeleafに渡すためのMapと呼ばれるデータ構造を持つ変数
   * Mapはkeyとvalueの組み合わせで値を保持する
   * QueryParam にしたら?もできるかも
   * //@RequestParamを@PathVariableにしたら成功した
   *
   * @param hand
   * @param model
   * @return
   *
   */

  @GetMapping("/fight/{hand}")
  public String jankengame(@PathVariable String hand, ModelMap model) {
    // じゃんけんの実装方法自分の手は無視して1/3にする
    if (hand.equals("Gu")) {
      String janResult = "あいこ";
      model.addAttribute("janResult", janResult);
      String janhand = "Gu";
      model.addAttribute("janhand", janhand);

    } else {
      String janResult = "不明";
      model.addAttribute("janResult", janResult);
      String janhand = "不明";
      model.addAttribute("janhand", janhand);
    }
    if (hand.equals("Cho")) {
      String janResult = "負け";
      model.addAttribute("janResult", janResult);
      String janhand = "Cho";
      model.addAttribute("janhand", janhand);
    }
    if (hand.equals("Pa")) {
      String janResult = "勝ち";
      model.addAttribute("janResult", janResult);
      String janhand = "Pa";
      model.addAttribute("janhand", janhand);
    }
    System.out.println("1234");
    // ModelMap型変数のmodelにtasuResult2という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    //return "janken.html";
    return "match.html";
  }

  /**
   * @param name
   * @param model
   * @return
   */

  // //getmappingは必ず残す
  @GetMapping("/janken")
  public String janken(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    Entry newRoom = new Entry();
    newRoom.addUser(loginUser);
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    model.addAttribute("new_room", newRoom);
    return "janken.html";
  }

   @PostMapping("/janken")
  //@GetMapping("/janken")
  @Transactional
  public String janken(String name, Principal prin, ModelMap model) {
  String loginUser = prin.getName();
  Entry newRoom = new Entry();
  newRoom.addUser(loginUser);
  this.room.addUser(loginUser);
  model.addAttribute("room", this.room);
  model.addAttribute("new_room", newRoom);

  ArrayList<User> users = userMapper.selectAllByUserName(name);
  model.addAttribute("users", users);
  // System.out.println("1234");

  // ArrayList<Match> matches = matchMapper.selectAllByMatch();
  // model.addAttribute("matches", matches);
  return "janken.html";
  }



  // @PostMapping("/janken")
  // @Transactional
  // public String janken(String name, Principal prin, ModelMap model) {
  //   ArrayList<User> users = userMapper.selectAllByUserName(name);
  //   model.addAttribute("users", users);
  //   return "janken.html";
  // }




}
// Bean
// selectAllByUser
