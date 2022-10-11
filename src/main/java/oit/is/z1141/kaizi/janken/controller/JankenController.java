package oit.is.z1141.kaizi.janken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Sample21Controller
 *
 * クラスの前に@Controllerをつけていると，HTTPリクエスト（GET/POSTなど）があったときに，このクラスが呼び出される
 */
@Controller
public class JankenController {
  /**
   * パスパラメータ2つをGETで受け付ける 1つ目の変数をparam1という名前で，2つ目の変数をparam2という名前で受け取る
   * GETで受け取った2つの変数とsample22()の引数の名前が同じなため， 引数の前に @PathVariable と付けるだけで，パスパラメータの値を
   * javaで処理できるようになる ModelMapはthymeleafに渡すためのMapと呼ばれるデータ構造を持つ変数
   * Mapはkeyとvalueの組み合わせで値を保持する
   *  QueryParam にしたら?もできるかも
   * //@RequestParamを@PathVariableにしたら成功した
   *
   * @param hand
   * @param model
   * @return
   *
   */

  @GetMapping("/jankengame/{hand}")
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
    // ModelMap型変数のmodelにtasuResult2という名前の変数で，tasuResultの値を登録する．
    // ここで値を登録するとthymeleafが受け取り，htmlで処理することができるようになる
    return "janken.html";
  }

  @GetMapping("/janken")
  public String janken( ModelMap model) {
    return "janken.html";
  }


  /**
   * POSTを受け付ける場合は@PostMappingを利用する /sample25へのPOSTを受け付けて，FormParamで指定された変数(input
   * name)をsample25()メソッドの引数として受け取ることができる
   *
   * @param name
   * @param model
   * @return
   */
  @PostMapping("/janken")
  public String janken(@RequestParam String name, ModelMap model) {

    model.addAttribute("Hi", name);
    return "janken.html";
  }

}
