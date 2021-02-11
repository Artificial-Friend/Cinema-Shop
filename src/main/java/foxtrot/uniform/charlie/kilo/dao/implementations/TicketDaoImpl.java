package foxtrot.uniform.charlie.kilo.dao.implementations;

import foxtrot.uniform.charlie.kilo.dao.TicketDao;
import foxtrot.uniform.charlie.kilo.exception.DataProcessingException;
import foxtrot.uniform.charlie.kilo.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl implements TicketDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public TicketDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Ticket add(Ticket ticket) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(ticket);
            transaction.commit();
            return ticket;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("ERROR: Can't add ticket " + ticket, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
