package atm;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ATMConfig {
    @Bean
    DataSource dataSource() {
        return new DataSourceDB();
    }

    @Bean
    Bank bank(DataSource dataSource) {
        return new Bank("My Bank", dataSource);
    }

    @Bean
    ATM atm(Bank bank) {
        return new ATM(bank);
    }

    @Bean
    AtmUI atmUI(ATM atm) {
        return new AtmUI(atm);
    }
}
