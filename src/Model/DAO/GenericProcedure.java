package Model.DAO;

import java.sql.SQLException;

import Exception.DaoException;  //devo importarla perché la ho in package differenti

public interface GenericProcedure<P> {
    P execute(Object... params) throws DaoException, SQLException;  //sarebbe tipo execute(param1,2,..)
}

/*NOTA: GenericProcedureDAO<P> è un'interfaccia generica, 
 * dove P rappresenta un tipo di dato generico (il tipo di ritorno del metodo execute).
 * Questo permette di usare questa interfaccia per qualsiasi tipo di operazione sul database, con il risultato specificato dal tipo P.
 * Ad esempio, potrebbe trattarsi di un'entità, un valore primitivo, una lista di oggetti, o qualsiasi altro tipo di dato.
 

P execute(Object... params) throws DAOException, SQLException;
execute() è il metodo principale dell'interfaccia. Prende un numero variabile di argomenti (Object... params) e restituisce un valore del tipo P.
Object... params è una varargs (un numero variabile di argomenti), che significa che puoi passare uno o più argomenti di tipo Object. 
Ad esempio, nel caso di un'operazione di login, questi argomenti potrebbero essere il nome utente e la password.
Il tipo P è il tipo che verrà restituito dal metodo execute. Potrebbe essere, ad esempio, un oggetto Credentials, una lista di oggetti, o qualsiasi altro tipo
*/