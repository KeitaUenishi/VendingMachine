package product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import product.domain.PurchaseForm;

/**
 * 自動販売機での商品購入コントローラーです。
 * 
 * @author koujienami
 */
@Controller
@RequestMapping
public class PurchaseController {

	/**
	 * 初期表示処理を行います。
	 * 
	 * @param form 画面フォーム
	 * @return 表示するテンプレート
	 */
	@GetMapping
	public String index(@ModelAttribute PurchaseForm form) {
		// TODO: 商品情報を取得するサービスから商品情報を取得し、画面に反映。
		return "index";
	}
}
