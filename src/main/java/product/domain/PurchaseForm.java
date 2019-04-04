package product.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * 自動販売機での商品購入を表現するフォームビーンです。
 * 
 * @author koujienami
 */
public class PurchaseForm {

	/** 商品一覧 **/
	private List<Product> list;

	/** 選択商品 */
	@NotBlank
	private String productId;

	/** 投入金額 */
	@NotBlank
	@Min(0)
	@Max(10000)
	private int amount;

	/** お釣り */
	@NotBlank
	@Min(0)
	@Max(10000)
	private int change;

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getChange() {
		return change;
	}

	public void setChange(int change) {
		this.change = change;
	}
}
