package co.grandcircus.jobtracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class JobController  {
	@Autowired
	private JobRepository jobs;

	@GetMapping("/JobPostings")
	public List<JobPosting> getAllPostings(@RequestParam String company_name) {
		if (company_name == null) {
			return jobs.findAll();
		} else {
			return jobs.findByCompanyName(company_name);
		}
	}
	
	@GetMapping("JobPostings/{id}")
	public JobPosting gePosting(@PathVariable Long id) {
		return jobs.findById(id).orElse(null);
	}
	
	@PostMapping("JobPostings")
	public JobPosting createPosting(@RequestBody JobPosting post) {
		post.setId(null);
		jobs.save(post);
		return post;
	}
	
	@PutMapping("JobPostings/{id}")
	public JobPosting updatePosting(@PathVariable Long id, @RequestBody JobPosting posting) {
		posting.setId(id);
		jobs.save(posting);
		return posting;
	}

	@DeleteMapping("JobPostings/{id}")
	public void deletePosting(@PathVariable Long id) {
		jobs.deleteById(id);
	}
}
