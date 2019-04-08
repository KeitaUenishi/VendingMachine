package product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product.domain.Product;
import product.repository.ProductRepository;

import java.util.List;

/**
 * 商品情報取得に関わる処理を行うサービスです。
 * 
 * @author koujienami
 */
@Service
public class GetProductService {

	/** 日付計算式リポジトリ */
	@Autowired
	private ProductRepository repository;

	/**
	 * 商品の一覧を全件検索して取得します。
	 * 
	 * @return 商品の全件
	 */
	public List<Product> search() {
		return repository.select();
	}
}
