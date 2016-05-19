package edu.flight_discounter.common;

public interface Methods {

    /* Common */
    public final static String GET                             = "/get";
    public final static String CREATE                          = "/create";
    public final static String SEARCH                          = "/search";
    public final static String DELETE                          = "/delete";
    public static final String EDIT                            = "/edit";

    /* User methods */
    public final static String GET_USERS_COUNT                 = "/getUsersCount";
    public final static String GET_SEARCH_COUNT                = "/getSearchCount";
    public final static String GET_CURRENT_PROFILE             = "/getCurrentProfile";
    public final static String GET_PROFILE                     = "/getProfile";
    public final static String CHANGE_PASSWORD                 = "/changePassword";
    public final static String CHANGE_CURRENT_PROFILE          = "/changeCurrentProfile";
    public final static String CHANGE_ROLE                     = "/changeRole";
    public final static String GET_LIST_USERS                  = "/getListUsers";
    public final static String GET_STUDENTS_FOR_TEACHER        = "/getStudentsForTeacher";
    public final static String CONFIRM                         = "/confirm";
    public final static String CHANGE_IMAGE                    = "/changeImage";
    public final static String GET_IMAGE                       = "/getImage";

    public final static String GET_DIRECTIONS                  = "/getDirections";
    public final static String GET_DIRECTION                   = "/getDirection";

    public final static String GET_USER                        = "/getUser";
    public final static String GET_ALL_USER                    = "/getAllUsers";
    public final static String CREATE_USER                     = "/createUser";
}
