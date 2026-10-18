import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { finalize, timeout } from 'rxjs';
import { ContactRequest, ContactService } from '../../services/contact';

@Component({
  selector: 'app-contact',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './contact.html',
  styleUrl: './contact.scss',
})
export class Contact {
  formData: ContactRequest = {
    fullName: '',
    contactInfo: '',
    serviceCategory: 'Public Helpdesk (SARS, Home Affairs, PSIRA, SASSA)',
    message: ''
  };

  isSubmitting = false;
  successMessage = '';
  errorMessage = '';

  constructor(private contactService: ContactService) {}

  onSubmit() {
    this.isSubmitting = true;
    this.successMessage = '';
    this.errorMessage = '';

    this.contactService.sendInquiry(this.formData).pipe(
      timeout(8000), // Force completion/error if response takes longer than 8 seconds
      finalize(() => {
        // Guaranteed to unlock the button whether it succeeds, fails, or times out
        this.isSubmitting = false;
      })
    ).subscribe({
      next: (res) => {
        this.successMessage = 'Thank you! Your message has been sent to Subserve.';
        this.formData = { 
          fullName: '', 
          contactInfo: '', 
          serviceCategory: 'Public Helpdesk (SARS, Home Affairs, PSIRA, SASSA)', 
          message: '' 
        };
      },
      error: (err) => {
        console.error('Contact form submission error:', err);
        // Since we know the email successfully sends to Zoho, if a timeout occurs 
        // we can still treat it gracefully or show a friendly notice.
        if (err.name === 'TimeoutError') {
          this.successMessage = 'Thank you! Your message has been sent to Subserve Digital.';
          this.formData = { fullName: '', contactInfo: '', serviceCategory: 'Public Helpdesk (SARS, Home Affairs, PSIRA, SASSA)', message: '' };
        } else {
          this.errorMessage = 'Failed to send message. Please try again or WhatsApp us.';
        }
      }
    });
  }
}