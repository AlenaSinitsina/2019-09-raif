package dz3;

enum ComparisonOperation {
    FULL_ON_ACCOUNT ("1 - Внести деньги на счет"),
    REMOTE_ON_ACCOUNT ("2 - Вывести деньги со счета"),
    TRANSFER_AMOUNT ("3 - Перевод на другой счет"),
    CLOSE ("0 - Выход из меню");

    private String text;

    ComparisonOperation(String text) {
        this.text = text;
    }
}

enum ComparisonAccount {
    CREDIT ("Кредит"),
    DEBIT ("Дебит"),
    CURRENT ("Текущий");

    private String text;

    ComparisonAccount(String text) {
        this.text = text;
    }
}


