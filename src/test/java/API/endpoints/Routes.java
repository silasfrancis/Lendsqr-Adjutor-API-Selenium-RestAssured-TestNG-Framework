package API.endpoints;

public class Routes{

    public static String Api_baseURL =  "https://adjutor.lendsqr.com/v2/";
    public static String ApiKey = "Bearer sk_live_Fjpdl33gRMavw3uSgWNmeuD0uVLDuwGBRaVW8Qyr";

    //Validation
    public static String post_initailzie_bvn = Api_baseURL + "verification/bvn/{bvn}";
    public static String put_getBvndetails = Api_baseURL + "verification/bvn/{bvn}";
    public static String post_initalize_bvnAccounts = Api_baseURL + "verification/bvn/{bvn}/accounts";

//    Credit Bureaus
    public static String get_creditReportCRC = Api_baseURL + "creditbureaus/crc/{bvn}";
    public static String get_creditReportFirstCentral = Api_baseURL + "creditbureaus/firstcentral/{bvn}";

//    Decisioning
    public static String get_decisionModels = Api_baseURL+ "decisioning/models";
    public static String get_decisionModelsDetails = Api_baseURL+ "decisioning/models/{id}/settings";
    public static String post_Oraculi_Borrower_Scoring = Api_baseURL+ "decisioning/models/{id}";

//    Embedded Loans And Payments
//    loans
    public static String get_loanProducts = Api_baseURL + "loans/products";
    public static String post_initializeLoanApplication = Api_baseURL + "loans/initialize";
    public static String get_loan = Api_baseURL + "loans/{reference}";

//    payment
    public static String post_initailizePayment = Api_baseURL + "payments/initialize";
    public static String get_QueryPayment = Api_baseURL + "payments/{reference}";

//    Data for lenders
    public static String get_options = Api_baseURL+"data/options";
    public static String get_users = Api_baseURL+"data/users";

//    Operational Services
    public static String get_AdjutorPricing =Api_baseURL+"profile/pricing";
    public static String get_wallet =Api_baseURL+"profile/wallet";
    public static String get_BankList =Api_baseURL+"banks";

//    Direct Debit
//    banks
    public static String get_allBanks =Api_baseURL+"direct-debit/{banks}";
    public static String get_bankDetails =Api_baseURL+"direct-debit/banks/{bank_id}";
    public static String post_verifyAccountNumber =Api_baseURL+"direct-debit/banks/account-lookup";

//    mandates
    public static String post_createMandate =Api_baseURL+"direct-debit/mandates";
    public static String get_allMandates=Api_baseURL+"direct-debit/{mandates}";
    public static String post_DebitMandate=Api_baseURL+"direct-debit/mandates/debit";

    public static String post_checkAccountBalance =Api_baseURL+"direct-debit/banks/balance-lookup";






}
