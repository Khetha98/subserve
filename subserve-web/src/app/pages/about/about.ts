import { Component, OnInit } from '@angular/core';
import { Title, Meta } from '@angular/platform-browser';

@Component({
  selector: 'app-about',
  standalone: true,
  imports: [],
  templateUrl: './about.html',
  styleUrl: './about.scss',
})
export class About implements OnInit {
  constructor(private title: Title, private meta: Meta) {}

  ngOnInit() {
    this.title.setTitle('About Subserve | Tech & Digital Services Hubs');
    this.meta.updateTag({ name: 'description', content: 'Subserve Digital empowers townships and communities across Soweto, Umlazi, and Khayelitsha through software engineering, POS systems, and administrative support.' });
    this.meta.updateTag({ property: 'og:title', content: 'About Subserve' });
    this.meta.updateTag({ property: 'og:description', content: 'Learn about Subserve Digital and our tech hub locations.' });
  }
}