package com.eventmanagement.listener;

import com.eventmanagement.dao.EventoDAO;
import com.eventmanagement.scheduler.EventoScheduler;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {
    
    private EventoScheduler scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("=== Aplicação iniciando ===");
        System.out.println("Iniciando EventoScheduler...");
        
        EventoDAO eventoDAO = new EventoDAO();
        scheduler = new EventoScheduler(eventoDAO);
        
        // Armazena no contexto para poder parar depois
        sce.getServletContext().setAttribute("eventoScheduler", scheduler);
        
        System.out.println("EventoScheduler iniciado com sucesso!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("=== Aplicação finalizando ===");
        
        if (scheduler != null) {
            scheduler.parar();
        }
        
        System.out.println("EventoScheduler parado.");
    }
}