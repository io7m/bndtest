#!/bin/sh

mkdir -p target/classes/META-INF
touch target/classes/META-INF/MANIFEST.MF
exec mvn package bnd-run:run@main

