package com.project.dietively.util

data class VaccinationScheduleData(
    val heading1: String = "BABY IMMUNIZATION SCHEDULE / VACCINATION CHART 2023-24",
    val information: String = "Right from the time of birth, till the age of 12, your child will be vulnerable to a host of diseases, viruses, and bacteria. At such a tender age, the body of your child may not have the required immune system to protect them from these communicable diseases. In an event, where your child may contract a disease or virus, the consequences may be dire. Certain diseases such as diphtheria, tetanus, whooping cough and HPV still exist today, and can still be easily be transmitted from one individual to another. In many parts of the world, vaccine-preventable diseases are still common, and there is every chance of your child contracting them.\n" +
            "\n" +
            "To prevent such an occurrence, the ideal solution is to protect your child through vaccination. Vaccinations ensure that your child is immune to certain communicable diseases, thus preventing them from contracting it or even suffering from the effects of it. In the occasion where they come into contact with an infected individual, the vaccinated child will not be affected by the serious effects or complications.\n" +
            "\n" +
            "Also, Read Vaccination Schedule and the Diseases They Protect Against\n" +
            "With timely baby vaccinations, your child will have a 90% chance of immunity against vaccine-preventable diseases. As different diseases can affect your child at different ages, it is crucial that you, as a parent, ensure the protection of your child. Apollo Cradle is well equipped and skilled in providing timely vaccinations for babies. Our team will provide you with adequate knowledge and specifics regarding each immunization and the appropriate immunization scheduling.",
    val heading2: String = "Baby Immunization Schedule Table (based on IAPCOI recommendations) ",
    val schedule: List<VaccinationSchedule> = listOf(
        VaccinationSchedule("Birth", listOf("BCG", "Hep B1", "OPV")),
        VaccinationSchedule(
            "6 weeks",
            listOf("DTwP /DTaP1", "Hib-1", "IPV-1", "Hep B2", "PCV 1", "Rota-1")
        ),
        VaccinationSchedule(
            "10 weeks",
            listOf("DTwP /DTaP2", "Hib-2", "IPV-2", "Hep B3", "PCV 2", "Rota-2")
        ),
        VaccinationSchedule(
            "14 weeks",
            listOf("DTwP /DTaP3", "Hib-3", "IPV-3", "Hep B4", "PCV 3", "Rota-3*")
        ),
        VaccinationSchedule("6 Months", listOf("Influenza-1")),
        VaccinationSchedule("7 Months", listOf("Influenza -2")),
        VaccinationSchedule("6 – 9 Months", listOf("Typhoid Conjugate Vaccine")),
        VaccinationSchedule("9 Months", listOf("MMR 1 (Mumps, measles, Rubella)")),
        VaccinationSchedule("12 Months", listOf("Hepatitis A- 1")),
        VaccinationSchedule("12 – 15 Months", listOf("PCV Booster")),
        VaccinationSchedule("15 Months", listOf("MMR 2", "Varicella")),
        VaccinationSchedule("16 – 18 Months", listOf("DTwP /DTaP", "Hib", "IPV")),
        VaccinationSchedule("18 – 19 Months", listOf("Hepatitis A- 2**", "Varicella 2")),
        VaccinationSchedule("4 – 6 Years", listOf("DTwP /DTaP", "IPV", "MMR 3")),
        VaccinationSchedule("9 – 15 Years (Girls)", listOf("HPV (2 doses)")),
        VaccinationSchedule("10 – 12 Years", listOf("Tdap/ Td")),
        VaccinationSchedule("2nd, 3rd, 4th and 5th Year", listOf("Annual Influenza Vaccine"))
    ),
    val reference: String = "https://www.apollocradle.com/specialities/paediatrics/immunization/vaccination-schedule/"

)




data class VaccinationSchedule(
    val month: String,
    val vaccines: List<String>
)

data class VaccinationDate(
    val month: Long,
    var vaccines: ArrayList<String>
)