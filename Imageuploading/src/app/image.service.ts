import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  private baseUrl = 'http://localhost:9090/api/images'; // Replace with your actual backend URL

  constructor(private http: HttpClient) { }

  getAllImagePaths(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}/get`);
  }
}
