import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ImageService } from '../image.service';

@Component({
  selector: 'app-all-images',
  templateUrl: './all-images.component.html',
  styleUrls: ['./all-images.component.css']
})
export class AllImagesComponent implements OnInit{

  imagePaths: string[] = [];
  selectedFile!: File;
  constructor(private imageService: ImageService,private http:HttpClient) { }
  

  ngOnInit(): void {
    this.loadImages();
  }

  loadImages(): void {
    this.imageService.getAllImagePaths().subscribe(paths => {
      this.imagePaths = paths;
    });
  }

  onFileSelected(event:any) {
    this.selectedFile = <File>event.target.files[0];
  }

  onUpload() {
    const fd = new FormData();
    fd.append('file', this.selectedFile, this.selectedFile.name);
    this.http.post<any>('http://localhost:9090/api/images/upload', fd)
      .subscribe(res => {
        alert("succesfuly uploaded")
        console.log(res);
      });
}


} 

