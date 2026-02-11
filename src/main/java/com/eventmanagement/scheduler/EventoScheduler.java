package com.eventmanagement.scheduler;

import com.eventmanagement.dao.EventoDAO;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EventoScheduler {
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
    private final EventoDAO eventoDAO;

    public EventoScheduler(EventoDAO eventoDAO) {
        this.eventoDAO = eventoDAO;
        iniciar();
    }

    private void iniciar() {

        scheduler.scheduleAtFixedRate(() -> {
            try {
                System.out.println("[SCHEDULER] Atualizando status dos eventos...");
                eventoDAO.atualizarStatusEventos();
                System.out.println("[SCHEDULER] Status atualizado com sucesso!");
            } catch (SQLException e) {
                System.err.println("[SCHEDULER] Erro ao atualizar status:");
                e.printStackTrace();
            }
        }, 0, 1, TimeUnit.MINUTES);
    }

    public void parar() {
        scheduler.shutdown();
        System.out.println("[SCHEDULER] Scheduler parado.");
    }
}