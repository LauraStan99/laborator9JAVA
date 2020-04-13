package org.example;

import org.example.entity.Albums;
import org.example.repo.AlbumRepository;

public class App
{
    public static void main( String[] args )
    {
        Albums album=new Albums();
        album.setName("HELLO-WORLD");
        album.setId(100);
        album.setArtistId(5);
        album.setReleaseYear(2020);
        AlbumRepository albumRepository=new AlbumRepository();
        albumRepository.create(album);

    }
}
