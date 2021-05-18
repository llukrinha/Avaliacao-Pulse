package com.AvaliacaoPulse.pulseavaliacao.exceptions;

public class RecursoJaExistente extends RuntimeException{
    public RecursoJaExistente(Class<?> c, Long id) {
        super(c.getSimpleName() + "com id" + id + "ja existe.");
    }
    public RecursoJaExistente(Class<?> c, String id) {
        super(c.getSimpleName() + "com valor" + id + "ja existe.");
    }
}
