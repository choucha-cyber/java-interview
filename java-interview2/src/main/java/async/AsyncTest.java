package async;

import java.util.concurrent.CompletableFuture;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.concurrent.Future;
import io.vavr.control.Option;

/**
 * You should complete the function in this class
 */
class AsyncTest {

	private static List<Enterprise> enterprises = List.of(
			new Enterprise("ent_1", "Google", "ceo_2"),
			new Enterprise("ent_2", "Facebook", "ceo_1"));

	private static List<Ceo> ceos = List.of(
			new Ceo("ceo_1", "Mark"),
			new Ceo("ceo_2", "Sundar"),
			new Ceo("ceo_3", "Bill"));

	public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {
		// return null;
		return Future.of(() -> ceos.find(ceo -> ceo.id.equals(ceo_id))).toCompletableFuture();
	}

	public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {
		// return null;
		return Future.of(() -> enterprises.find(enterprise -> enterprise.ceo_id.equals(ceo_id))).toCompletableFuture();

	}

	public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) {
		// return null;
		CompletableFuture<Option<Ceo>> ceoFuture = getCeoById(ceo_id);
		CompletableFuture<Option<Enterprise>> enterpriseFuture = getEnterpriseByCeoId(ceo_id);

		return ceoFuture.thenCombine(enterpriseFuture, Tuple::of);
	}

}
