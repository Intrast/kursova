package xlist.dao;

import xlist.models.AllList;

import java.util.List;

public interface ListDao {
        /**
         * Виводить список заміток, що створив користувач
         * @param id User
         * @return List class Note
         */
        List<AllList> getListByUserId(long id);

        AllList getListsById(long id);
    }


