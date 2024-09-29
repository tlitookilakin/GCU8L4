package co.grandcircus.jobtracker;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class CompanyController {
	@Autowired
	private CompanyRepository companies;

	@GetMapping("/companies")
	public List<Company> getAll() {
		return companies.findAll();
	}
	
	@GetMapping("/companies/{id}")
	public Company getCompany(@PathVariable Long id) {
		return companies.findById(id).orElse(null);
	}
	
	@PostMapping("/companies")
	public Company createCompany(@RequestBody Company company) {
		company.setId(null);
		companies.save(company);
		return company;
	}
	
	@PutMapping("companies/{id}")
	public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
		company.setId(id);
		companies.save(company);
		return company;
	}

	@DeleteMapping("companies/{id}")
	public void deleteCompany(@PathVariable Long id) {
		companies.deleteById(id);
	}
}
