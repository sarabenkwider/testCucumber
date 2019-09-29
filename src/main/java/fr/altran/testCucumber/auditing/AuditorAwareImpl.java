package fr.altran.testCucumber.auditing;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;

public class AuditorAwareImpl implements AuditorAware<String> {

	/*
	 * Auteur : Sara BENKOUIDER
	 */

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable("Sara BENKOUIDER");
	}
}
