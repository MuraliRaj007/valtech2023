package com.valtech.training.invoicespringboot.components;

import java.util.List;

public interface CompanyDAO {
void createCompany(Company company);
long count();
void deleteCompany(int companyId);
void updateCompany(Company company);
List<Company> getAllCompany();
Company getCompany(int companyId) ;
}
