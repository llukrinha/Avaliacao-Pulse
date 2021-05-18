package com.AvaliacaoPulse.pulseavaliacao.exceptions;

public class RecursoNaoEncontradoException extends RuntimeException {

    public RecursoNaoEncontradoException(Class<?> c, Long id) {
        super(c.getSimpleName() + "com id" + id + "inexistente.");
    }
    public RecursoNaoEncontradoException(Class<?> c, String id) {
        super(c.getSimpleName() + "com numero" + id + "inexistente.");
    }
}
